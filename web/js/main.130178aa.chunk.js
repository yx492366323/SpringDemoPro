(this.webpackJsonpregister = this.webpackJsonpregister || []).push([[0], {
    167: function (e, t, r) {
        "use strict";
        r.r(t);
        var a = r(0), s = r(24), n = r.n(s), o = (r(93), function (e) {
                e && e instanceof Function && r.e(3).then(r.bind(null, 173)).then((function (t) {
                    var r = t.getCLS, a = t.getFID, s = t.getFCP, n = t.getLCP, o = t.getTTFB;
                    r(e), a(e), s(e), n(e), o(e)
                }))
            }), i = r(29), c = r(58), u = r(170), l = r(171), d = r(86), m = r(39), j = r.n(m), b = (r(94), r(95), r(19)),
            g = "", f = "";

        function p(e, t) {
            if (!e.target.value) return {validateStatus: "error", errorMsg: "Please input your username!"};
            var r = "/User/isUserExist?UserName=" + e.target.value, a = !1;
            return j.a.ajax({
                url: r, type: "GET", async: !1, success: function (e) {
                    e && (a = !0)
                }
            }), a ? (function (e) {
                var t = "/User/getQuestion?UserName=" + e;
                j.a.ajax({
                    url: t, type: "GET", async: !1, success: function (e) {
                        f = e
                    }
                })
            }(e.target.value), g = e.target.value, {
                validateStatus: "success",
                errorMsg: null
            }) : {validateStatus: "error", errorMsg: "User does not exist\uff01"}
        }

        var h = {labelCol: {xs: {span: 24}, sm: {span: 8}}, wrapperCol: {xs: {span: 24}, sm: {span: 16}}},
            w = {wrapperCol: {xs: {span: 24, offset: 0}, sm: {span: 16, offset: 8}}}, v = function () {
                var e = Object(a.useState)({}), t = Object(c.a)(e, 2), r = t[0], s = t[1], n = Object(a.useState)({}),
                    o = Object(c.a)(n, 2), m = o[0], v = o[1], y = u.a.useForm(), O = Object(c.a)(y, 1)[0];
                console.log(O);
                return Object(b.jsxs)(u.a, Object(i.a)(Object(i.a)({}, h), {}, {
                    form: O,
                    method: "post",
                    action: "/User/changePassword",
                    name: "forgot",
                    id: "components-form-demo-normal-register",
                    onFinish: function (e) {
                        delete e.Confirm, delete e.SecurityQuestion, console.log(e), e._csrf = document.getElementById("csrf").value, console.log(e), console.log(JSON.stringify(e)), j.a.ajax({
                            url: "/User/changePassword",
                            type: "POST",
                            data: e,
                            success: function (e) {
                                e ? (alert("\u4fee\u6539\u6210\u529f\u3002"), window.location.replace("/login.html")) : alert("\u4fee\u6539\u5931\u8d25\u3002")
                            }
                        })
                    },
                    initialValues: {prefix: "86"},
                    scrollToFirstError: !0,
                    children: [Object(b.jsx)(u.a.Item, {
                        name: "UserName",
                        label: "Username",
                        tooltip: "You will log in with your username.",
                        validateStatus: r.validateStatus,
                        hasFeedback: !0,
                        help: r.errorMsg,
                        children: Object(b.jsx)(l.a, {
                            name: "UserName", onBlur: function (e) {
                                s(Object(i.a)(Object(i.a)({}, p(e)), {}, {value: e})), O.setFieldsValue({SecurityQuestion: f})
                            }
                        })
                    }), Object(b.jsx)(u.a.Item, {
                        name: "Password",
                        label: "Password",
                        rules: [{
                            required: !0,
                            pattern: /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/,
                            message: "The password must contain letters and numbers, and cannot be less than 6 digits, and cannot be more than 20 digits!"
                        }, function (e) {
                            var t = e.getFieldValue;
                            return {
                                validator: function (e, r) {
                                    return r && t("Password") !== r ? Promise.reject(new Error("The two passwords that you entered do not match!")) : Promise.resolve()
                                }
                            }
                        }],
                        hasFeedback: !0,
                        children: Object(b.jsx)(l.a.Password, {name: "Password"})
                    }), Object(b.jsx)(u.a.Item, {
                        name: "Confirm",
                        label: "Confirm Password",
                        dependencies: ["password"],
                        hasFeedback: !0,
                        rules: [{required: !0, message: "Please confirm your password!"}, function (e) {
                            var t = e.getFieldValue;
                            return {
                                validator: function (e, r) {
                                    return r && t("Password") !== r ? Promise.reject(new Error("The two passwords that you entered do not match!")) : Promise.resolve()
                                }
                            }
                        }],
                        children: Object(b.jsx)(l.a.Password, {})
                    }), Object(b.jsx)(u.a.Item, {
                        name: "SecurityQuestion",
                        label: "Security Question",
                        children: Object(b.jsx)(l.a, {id: "QuestionInput", name: "SecurityQuestion"})
                    }), Object(b.jsx)(u.a.Item, {
                        name: "SecurityAnswer",
                        label: "Security Answer",
                        tooltip: "We reminded you to remember the secret protection answer you filled in at the time of registration.",
                        validateStatus: m.validateStatus,
                        hasFeedback: !0,
                        help: m.errorMsg,
                        children: Object(b.jsx)(l.a, {
                            name: "SecurityAnswer", onBlur: function (e) {
                                v(Object(i.a)(Object(i.a)({}, function (e) {
                                    if (!g) return {validateStatus: "error", errorMsg: "Please input your username!"};
                                    if (!e.target.value) return {
                                        validateStatus: "error",
                                        errorMsg: "Please enter your security answer!"
                                    };
                                    var t = "/User/verifyAnswer?UserName=" + g + "&SecurityAnswer=" + e.target.value,
                                        r = !1;
                                    return j.a.ajax({
                                        url: t, type: "GET", async: !1, success: function (e) {
                                            e && (r = !0)
                                        }
                                    }), r ? {validateStatus: "success", errorMsg: null} : {
                                        validateStatus: "error",
                                        errorMsg: "Please enter the correct answer\uff01"
                                    }
                                }(e)), {}, {value: e}))
                            }
                        })
                    }), Object(b.jsx)(u.a.Item, Object(i.a)(Object(i.a)({}, w), {}, {
                        children: Object(b.jsx)(d.a, {
                            type: "primary",
                            htmlType: "submit",
                            children: "Confirm"
                        })
                    }))]
                }))
            };
        n.a.render(Object(b.jsx)(v, {}), document.getElementById("Register")), o()
    }, 93: function (e, t, r) {
    }, 95: function (e, t, r) {
    }
}, [[167, 1, 2]]]);
//# sourceMappingURL=main.c8feab0a.chunk.js.map