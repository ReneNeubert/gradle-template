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

package com.netflix.template.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Container for words going back and forth.
 *
 * @author jryan
 */
@XmlRootElement
public class Sentence {

    private String whole;

    @SuppressWarnings("unused")
    private Sentence() {

    }

    /**
     * Initialize sentence.
     *
     * @param whole as string
     */
    public Sentence(final String whole) {

        this.whole = whole;
    }

    /**
     * whole getter.
     *
     * @return a string
     */
    @XmlElement
    public String getWhole() {

        return whole;
    }

    /**
     *
     * @param whole a string.
     */
    public void setWhole(final String whole) {

        this.whole = whole;
    }
}
