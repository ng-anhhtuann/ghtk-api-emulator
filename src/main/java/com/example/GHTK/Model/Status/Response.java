package com.example.GHTK.Model.Status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("status")
    @Expose
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Response(boolean status, Object object) {
        this.status = status;
        this.object = object;
    }

    @SerializedName("object")
    @Expose
    private Object object;
}
