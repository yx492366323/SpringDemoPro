(this.webpackJsonpregister = this.webpackJsonpregister || []).push([[0], {
    111: function (e, r, a) {
    }, 113: function (e, r, a) {
    }, 185: function (e, r, a) {
        "use strict";
        a.r(r);
        var t = a(0), s = a(28), n = a.n(s), o = (a(111), function (e) {
                e && e instanceof Function && a.e(3).then(a.bind(null, 194)).then((function (r) {
                    var a = r.getCLS, t = r.getFID, s = r.getFCP, n = r.getLCP, o = r.getTTFB;
                    a(e), t(e), s(e), n(e), o(e)
                }))
            }), l = a(35), i = a(83), u = a(190), c = a(189), m = a(191), d = a(188), b = a(193), j = a(72), h = a(95),
            p = a.n(h), g = (a(112), a(113), a(10));
        var y = u.a.Option,
            x = {labelCol: {xs: {span: 24}, sm: {span: 8}}, wrapperCol: {xs: {span: 24}, sm: {span: 16}}},
            O = {wrapperCol: {xs: {span: 24, offset: 0}, sm: {span: 16, offset: 8}}}, w = function () {
                var e = Object(t.useState)({}), r = Object(i.a)(e, 2), a = r[0], s = r[1], n = c.a.useForm(),
                    o = Object(i.a)(n, 1)[0], h = Object(g.jsx)(c.a.Item, {
                        name: "prefix",
                        noStyle: !0,
                        children: Object(g.jsxs)(u.a, {
                            style: {width: 70},
                            children: [Object(g.jsx)(y, {value: "86", children: "+86"}), Object(g.jsx)(y, {
                                value: "87",
                                children: "+87"
                            })]
                        })
                    });
                return Object(g.jsxs)(c.a, Object(l.a)(Object(l.a)({}, x), {}, {
                    form: o,
                    method: "post",
                    action: "/User/registerUser",
                    name: "register",
                    id: "components-form-demo-normal-register",
                    onFinish: function (e) {
                        document.getElementById("components-form-demo-normal-register").appendChild(document.getElementById("csrf")), document.getElementById("Sex").value = e.Sex, document.getElementById("components-form-demo-normal-register").submit()
                    },
                    initialValues: {prefix: "86"},
                    scrollToFirstError: !0,
                    children: [Object(g.jsx)(c.a.Item, {
                        name: "UserName",
                        label: "Username",
                        tooltip: "You will log in with your username.",
                        validateStatus: a.validateStatus,
                        hasFeedback: !0,
                        help: a.errorMsg,
                        children: Object(g.jsx)(m.a, {
                            name: "UserName", onBlur: function (e) {
                                s(Object(l.a)(Object(l.a)({}, function (e) {
                                    var r = "/User/isUserExist?UserName=" + e.target.value;
                                    if (!e.target.value) return {
                                        validateStatus: "error",
                                        errorMsg: "Please input your username!"
                                    };
                                    var a = !1;
                                    return p.a.ajax({
                                        url: r,
                                        type: "GET",
                                        datatype: {UserName: e.target.value},
                                        async: !1,
                                        success: function (e) {
                                            console.log(e), e && (a = !0)
                                        }
                                    }), console.log(a), a ? {
                                        validateStatus: "error",
                                        errorMsg: "The user name has already been used!"
                                    } : {validateStatus: "success", errorMsg: null}
                                }(e)), {}, {value: e}))
                            }
                        })
                    }), Object(g.jsx)(c.a.Item, {
                        name: "Password",
                        label: "Password",
                        rules: [{
                            required: !0,
                            pattern: /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/,
                            message: "The password must contain letters and numbers, and cannot be less than 6 digits, and cannot be more than 20 digits!"
                        }, function (e) {
                            var r = e.getFieldValue;
                            return {
                                validator: function (e, a) {
                                    return a && r("Password") !== a ? Promise.reject(new Error("The two passwords that you entered do not match!")) : Promise.resolve()
                                }
                            }
                        }],
                        hasFeedback: !0,
                        children: Object(g.jsx)(m.a.Password, {name: "Password"})
                    }), Object(g.jsx)(c.a.Item, {
                        name: "Confirm",
                        label: "Confirm Password",
                        dependencies: ["password"],
                        hasFeedback: !0,
                        rules: [{required: !0, message: "Please confirm your password!"}, function (e) {
                            var r = e.getFieldValue;
                            return {
                                validator: function (e, a) {
                                    return a && r("Password") !== a ? Promise.reject(new Error("The two passwords that you entered do not match!")) : Promise.resolve()
                                }
                            }
                        }],
                        children: Object(g.jsx)(m.a.Password, {})
                    }), Object(g.jsx)(c.a.Item, {
                        name: "Email",
                        label: "E-mail",
                        hasFeedback: !0,
                        rules: [{type: "email", message: "The input is not valid E-mail!"}, {
                            required: !0,
                            message: "Please input your E-mail!"
                        }],
                        children: Object(g.jsx)(m.a, {name: "Email"})
                    }), Object(g.jsx)(c.a.Item, {
                        name: "TrueName",
                        label: "Truename",
                        rules: [{required: !0, message: "Please input your truename!", whitespace: !0}],
                        children: Object(g.jsx)(m.a, {name: "TrueName"})
                    }), Object(g.jsx)(c.a.Item, {
                        name: "IDCardNumber",
                        label: "IDCard",
                        tooltip: "Please enter your student number.",
                        hasFeedback: !0,
                        rules: [{required: !0, pattern: /^20\d{8}$/, message: "Please input your IDCard number!"}],
                        children: Object(g.jsx)(m.a, {name: "IDCardNumber"})
                    }), Object(g.jsx)(c.a.Item, {
                        name: "Sex",
                        label: "Gender",
                        rules: [{required: !0, message: "Please select gender!"}],
                        children: Object(g.jsxs)(u.a, {
                            name: "Sex",
                            placeholder: "select your gender",
                            children: [Object(g.jsx)(y, {
                                value: "true",
                                children: "Male"
                            }), Object(g.jsx)(y, {value: "false", children: "Female"})]
                        })
                    }), Object(g.jsx)("input", {name: "Sex", id: "Sex"}), Object(g.jsx)(c.a.Item, {
                        name: "BirthDay",
                        label: "BirthDay",
                        children: Object(g.jsx)(d.a, {name: "BirthDay"})
                    }), Object(g.jsx)(c.a.Item, {
                        name: "BuildingNumber",
                        label: "Residence",
                        rules: [{
                            required: !0,
                            pattern: /(^D[1-9]{1}$)|(^D1[0-1]$)|(^A[1-3]{1}$)|(^J[1-2]{1}$)|(^C[568]{1}$)/,
                            message: "Please enter your habitual residence! You can only select C5, C6, C8, D1-D10, J1, J2 and A1-A3."
                        }],
                        children: Object(g.jsx)(m.a, {name: "BuildingNumber"})
                    }), Object(g.jsx)(c.a.Item, {
                        name: "PhoneNumber",
                        label: "Phone Number",
                        hasFeedback: !0,
                        rules: [{required: !0, pattern: /^1\d{10}$/, message: "Please input your phone number!"}],
                        children: Object(g.jsx)(m.a, {name: "PhoneNumber", addonBefore: h, style: {width: "100%"}})
                    }), Object(g.jsx)(c.a.Item, {
                        name: "SecurityQuestion",
                        label: "Security Question",
                        tooltip: "You may need it when you forget your password, but you don't need to remember it, because we will provide it when you forget your password.",
                        rules: [{required: !0, message: "Please enter your security question!"}],
                        children: Object(g.jsx)(m.a, {name: "SecurityQuestion"})
                    }), Object(g.jsx)(c.a.Item, {
                        name: "SecurityAnswer",
                        label: "Security Answer",
                        tooltip: "You may need it when you forget your password, you need to remember it.",
                        rules: [{required: !0, message: "Please enter your security answer!"}],
                        children: Object(g.jsx)(m.a, {name: "SecurityAnswer"})
                    }), Object(g.jsx)(c.a.Item, Object(l.a)(Object(l.a)({
                        name: "agreement",
                        valuePropName: "checked",
                        rules: [{
                            validator: function (e, r) {
                                return r ? Promise.resolve() : Promise.reject(new Error("Should accept agreement"))
                            }
                        }]
                    }, O), {}, {
                        children: Object(g.jsxs)(b.a, {
                            children: ["I have read the ", Object(g.jsx)("a", {
                                href: "/agreement.html",
                                target: "_blank",
                                children: "agreement"
                            })]
                        })
                    })), Object(g.jsx)(c.a.Item, Object(l.a)(Object(l.a)({}, O), {}, {
                        children: Object(g.jsx)(j.a, {
                            type: "primary",
                            htmlType: "submit",
                            children: "Register"
                        })
                    }))]
                }))
            };
        n.a.render(Object(g.jsx)(w, {}), document.getElementById("Register")), o()
    }
}, [[185, 1, 2]]]);
//# sourceMappingURL=main.112f7032.chunk.js.map