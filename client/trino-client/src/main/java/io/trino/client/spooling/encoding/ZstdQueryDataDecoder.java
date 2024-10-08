/*
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
package io.trino.client.spooling.encoding;

import io.airlift.compress.zstd.ZstdInputStream;
import io.trino.client.QueryDataDecoder;

import java.io.InputStream;

public class ZstdQueryDataDecoder
        extends CompressedQueryDataDecoder
{
    public ZstdQueryDataDecoder(QueryDataDecoder delegate)
    {
        super(delegate);
    }

    @Override
    InputStream decompress(InputStream inputStream, int uncompressedSize)
    {
        return new ZstdInputStream(inputStream);
    }

    @Override
    public String encodingId()
    {
        return delegate.encodingId() + "+zstd";
    }
}
