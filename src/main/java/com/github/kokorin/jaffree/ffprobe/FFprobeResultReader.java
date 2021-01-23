/*
 *    Copyright  2018 Denis Kokorin
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

package com.github.kokorin.jaffree.ffprobe;

import com.github.kokorin.jaffree.ffprobe.data.Data;
import com.github.kokorin.jaffree.ffprobe.data.FormatParser;
import com.github.kokorin.jaffree.process.StdReader;

import java.io.InputStream;

/**
 * {@link FFprobeResultReader} adapts {@link StdReader} to {@link FormatParser}.
 */
public class FFprobeResultReader implements StdReader<FFprobeResult> {

    private final FormatParser parser;

    /**
     * Creates {@link FFprobeResultReader}.
     *
     * @param parser parser
     */
    public FFprobeResultReader(final FormatParser parser) {
        this.parser = parser;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FFprobeResult read(final InputStream stdOut) {
        Data data = parser.parse(stdOut);

        return new FFprobeResult(data);
    }
}