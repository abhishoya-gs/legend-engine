// Copyright 2020 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.engine.protocol.pure.v1.model.context;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "_type", defaultImpl = PureModelContextData.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PureModelContextData.class, name = "data"),
        @JsonSubTypes.Type(value = PureModelContextText.class, name = "text"),
        @JsonSubTypes.Type(value = PureModelContextPointer.class, name = "pointer"),
        @JsonSubTypes.Type(value = PureModelContextCollection.class, name = "collection")
})
public abstract class PureModelContext
{
}
