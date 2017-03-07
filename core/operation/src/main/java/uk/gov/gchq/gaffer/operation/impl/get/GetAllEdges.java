/*
 * Copyright 2016 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.operation.impl.get;

import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import java.util.Collections;

/**
 * Restricts {@link GetAllElements} to only return edges.
 */
public class GetAllEdges extends GetAllElements<Edge> {
    @Override
    public void setView(final View view) {
        if (null != view && view.hasEntities()) {
            super.setView(new View.Builder()
                    .merge(view)
                    .entities(Collections.emptyMap())
                    .build());
        } else {
            super.setView(view);
        }
    }

    public abstract static class BaseBuilder<CHILD_CLASS extends BaseBuilder<?>>
            extends GetAllElements.BaseBuilder<GetAllEdges, Edge, CHILD_CLASS> {
        public BaseBuilder() {
            this(new GetAllEdges());
        }

        public BaseBuilder(final GetAllEdges op) {
            super(op);
        }
    }

    public static final class Builder extends BaseBuilder<Builder> {
        public Builder() {
            this(new GetAllEdges());
        }

        public Builder(final GetAllEdges op) {
            super(op);
        }

        @Override
        public Builder self() {
            return this;
        }
    }
}
