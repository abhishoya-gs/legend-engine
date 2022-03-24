// Copyright 2021 Goldman Sachs
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

package org.finos.legend.engine.protocol.pure.v1.model.packageableElement.store.service.mapping;

import org.finos.legend.engine.protocol.pure.v1.model.SourceInformation;
import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.store.service.model.ServicePtr;
import org.finos.legend.engine.protocol.pure.v1.model.valueSpecification.raw.path.Path;

import java.util.List;

public class ServiceMapping
{
    public ServicePtr service;

    public Path pathOffset;
    public ServiceRequestBuildInfo requestBuildInfo;

    @Deprecated
    public List<ServiceParameterMapping> parameterMappings;

    public SourceInformation sourceInformation;
}
