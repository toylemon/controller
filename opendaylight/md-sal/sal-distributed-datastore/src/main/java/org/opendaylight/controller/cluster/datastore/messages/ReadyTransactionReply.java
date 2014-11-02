/*
 * Copyright (c) 2014 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.controller.cluster.datastore.messages;

import org.opendaylight.controller.protobuff.messages.transaction.ShardTransactionMessages;

public class ReadyTransactionReply implements SerializableMessage {
    public static final Class<ShardTransactionMessages.ReadyTransactionReply> SERIALIZABLE_CLASS =
            ShardTransactionMessages.ReadyTransactionReply.class;

    private final String cohortPath;

    public ReadyTransactionReply(String cohortPath) {
        this.cohortPath = cohortPath;
    }

    public String getCohortPath() {
        return cohortPath;
    }

    @Override
    public ShardTransactionMessages.ReadyTransactionReply toSerializable() {
        return ShardTransactionMessages.ReadyTransactionReply.newBuilder()
                .setActorPath(cohortPath)
                .build();
    }

    public static ReadyTransactionReply fromSerializable(Object serializable) {
        ShardTransactionMessages.ReadyTransactionReply o =
                (ShardTransactionMessages.ReadyTransactionReply) serializable;

        return new ReadyTransactionReply(o.getActorPath());
    }
}
