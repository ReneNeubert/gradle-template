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

package org.softcake.template.two;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.function.Supplier;

/**
 * @author René Neubert
 */
@Tag("fast")
class TwoTest {

    @Test
    @DisplayName("get name with custom name!")
    void getNameWithCustomName(final TestInfo testInfo) {

        String name = "Custom";
        Two two = new Two(name);
        assertEquals(two.getName(), name);
        assertEquals("get name with custom name!", testInfo.getDisplayName(), new
                Supplier<String>() {

            @Override
            public String get() {

                return "TestInfo is " + "injected correctly";
            }
        });
    }

    @Test
    @DisplayName("get name with default name!")
    void getName(final TestInfo testInfo) {

        Two two = new Two();
        assertEquals(two.getName(), "Two");
        assertEquals("get name with default name!", testInfo.getDisplayName(), new
                Supplier<String>() {

            @Override
            public String get() {

                return "TestInfo is " + "injected correctly";
            }
        });
    }

    @Test
    @Disabled
    void mySecondTest() {

        assertEquals(2, 1, "2 is not equal to 1");
    }

    @Test
    @Tag("slow")
    void slowTest() throws InterruptedException {

        Thread.sleep(1000);
    }

}
