/*
 * Copyright 2017 Crown Copyright
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

package uk.gov.gchq.gaffer.data.elementdefinition.view;

import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Properties;

public final class ViewUtil {
    private ViewUtil() {
    }

    public static void removeProperties(final View view, final Element element) {
        if (null != view && null != element) {
            removeProperties(view.getElement(element.getGroup()), element);
        }
    }

    public static void removeProperties(final ViewElementDefinition elDef, final Element element) {
        removeProperties(elDef, element.getProperties());
    }

    public static void removeProperties(final ViewElementDefinition elDef, final Properties properties) {
        if (null != elDef && !elDef.isAllProperties()) {
            if (null == elDef.getProperties()) {
                elDef.getExcludeProperties().forEach(properties::remove);
            } else {
                properties.keepOnly(elDef.getProperties());
            }
        }
    }
}
