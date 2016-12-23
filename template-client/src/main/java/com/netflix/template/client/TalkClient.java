/*
 * Copyright 2016 Softcake.
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

package com.netflix.template.client;

import com.netflix.template.common.Conversation;
import com.netflix.template.common.Sentence;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;

import javax.ws.rs.core.MediaType;

/**
 * Delegates to remote TalkServer over REST.
 *
 * @author jryan
 */
public class TalkClient implements Conversation {

    private WebResource webResource;

    /**
     * Instantiate client.
     *
     * @param location URL to the base of resources, e.g. http://localhost:8080/template-server/rest
     */
    public TalkClient(final String location) {

        Client client = Client.create();
        client.addFilter(new LoggingFilter(System.out));
        webResource = client.resource(location + "/talk");
    }

    /**
     * Tests out client.
     *
     * @param args Not applicable
     */
    public static void main(final String... args) {

        final String url = "http://localhost:8080/template-server/rest";
        TalkClient remote = new TalkClient(url);
        System.out.println(remote.greeting().getWhole());
        System.out.println(remote.farewell().getWhole());
    }

    @Override
    public Sentence greeting() {

        return webResource.accept(MediaType.APPLICATION_XML).get(Sentence.class);
    }

    @Override
    public Sentence farewell() {

        return webResource.accept(MediaType.APPLICATION_XML).delete(Sentence.class);
    }
}
