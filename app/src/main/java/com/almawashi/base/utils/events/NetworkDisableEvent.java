package com.almawashi.base.utils.events;



public class NetworkDisableEvent extends BaseEvent<String> {
    public NetworkDisableEvent(String key, String object) {
        super(key, object);
        setKey(EventsContract.NETWORK_DISABLED);
    }
}
