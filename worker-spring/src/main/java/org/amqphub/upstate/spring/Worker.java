/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.amqphub.upstate.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Simple Reply Service example that sends and receives a message to the
 * configured JMSReplyTo address using Qpid JMS
 */
@SpringBootApplication
@EnableJms
public class Worker {
    public static void main(String[] args) {
        SpringApplication.run(Worker.class, args);
    }

    @Component
    static class MessageHandler {
        @JmsListener(destination = "example")
        public String processMsg(String message) {
            System.out.println("WORKER: XXX " + message);

            message = message.toUpperCase();

            System.out.println("WORKER: YYY " + message);

            return message;
        }
    }
}
