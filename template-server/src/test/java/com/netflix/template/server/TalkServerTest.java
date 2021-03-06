/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.template.server;

import static org.hamcrest.core.Is.is;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author René Neubert.
 */
public class TalkServerTest {

    @Test
    public void farewell() throws Exception {
        TalkServer talkServer = new TalkServer();
        String whole = talkServer.farewell().getWhole();
        Assert.assertThat(whole, is("Goodbye"));
    }

    @Test
    public void greeting() throws Exception {

        TalkServer talkServer = new TalkServer();
        String whole = talkServer.greeting().getWhole();
        Assert.assertThat(whole, is("Hello"));
    }

}
