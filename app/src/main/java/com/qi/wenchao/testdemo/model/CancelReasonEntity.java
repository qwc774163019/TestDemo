package com.qi.wenchao.testdemo.model;

import java.io.Serializable;

/**
 * @author chao
 * @Description {todo}
 * @date 2017/8/21 上午11:13
 * @todo:
 */
public class CancelReasonEntity implements Serializable {

    int id ;
    boolean isChecked;
    String reasonStr;
    String subReasonStr;

    public CancelReasonEntity(int id, String reasonStr) {
        this.id = id;
        this.reasonStr = reasonStr;
    }

    public CancelReasonEntity(int id, boolean isChecked, String reasonStr) {
        this.id = id;
        this.isChecked = isChecked;
        this.reasonStr = reasonStr;
    }

    public CancelReasonEntity(int id, String reasonStr, String subReasonStr) {
        this.id = id;
        this.reasonStr = reasonStr;
        this.subReasonStr = subReasonStr;
    }


    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getSubReasonStr() {
        return subReasonStr;
    }

    public void setSubReasonStr(String subReasonStr) {
        this.subReasonStr = subReasonStr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReasonStr() {
        return reasonStr;
    }

    public void setReasonStr(String reasonStr) {
        this.reasonStr = reasonStr;
    }
}
