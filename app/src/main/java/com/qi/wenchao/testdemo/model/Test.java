package com.qi.wenchao.testdemo.model;

import java.util.List;

/**
 * @author chao
 * @Description {todo}
 * @date 2017/1/5 上午11:31
 * @todo:
 */
public class Test {

    /**
     * ret_code : 12014
     * ret_msg :
     * result : {"content":"您的余额不足以支付本次行程，请充值或绑信用卡后再订车","btns":[{"title":"去充值","url":"http://testing.h5.yongche.org/payment.html"},{"title":"去绑信用卡","url":"bindCard"}]}
     */

    private int ret_code;
    private String ret_msg;
    private ResultBean result;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * content : 您的余额不足以支付本次行程，请充值或绑信用卡后再订车
         * btns : [{"title":"去充值","url":"http://testing.h5.yongche.org/payment.html"},{"title":"去绑信用卡","url":"bindCard"}]
         */

        private String content;
        private List<BtnsBean> btns;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<BtnsBean> getBtns() {
            return btns;
        }

        public void setBtns(List<BtnsBean> btns) {
            this.btns = btns;
        }

        public static class BtnsBean {
            /**
             * title : 去充值
             * url : http://testing.h5.yongche.org/payment.html
             */

            private String title;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
