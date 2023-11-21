// Copyright 2023 Goldman Sachs
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

package org.finos.legend.engine.protocol.pure.v1.model.connection;

import org.finos.legend.engine.protocol.pure.v1.packageableElement.connection.ConnectionSpecification;

public class StaticJDBCConnectionSpecification extends ConnectionSpecification
{
    public String host;
    public int port;
    public String databaseName;

    public StaticJDBCConnectionSpecification()
    {
        // jackson
    }

    public StaticJDBCConnectionSpecification(String host, int port, String databaseName)
    {
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
    }

    @Override
    public String shortId()
    {
        return "StaticJDBC" +
                "--host=" + host +
                "--port=" + port +
                "--databaseName=" + databaseName;
    }
}