<%--
  Created by IntelliJ IDEA.
  User: yx492
  Date: 2021/12/1
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link rel="icon" href="./favicon.ico"/>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <meta name="theme-color" content="#000000"/>
    <meta name="description" content="Web site created using create-react-app"/>
    <link rel="apple-touch-icon" href="./logo192.png"/>
    <link rel="manifest" href="./manifest.json"/>
    <title>React App</title>
    <link href="./static/css/2.09765660.chunk.css" rel="stylesheet">
    <link href="./static/css/main.c2c094ac.chunk.css" rel="stylesheet">
</head>
<body>
<noscript>You need to enable JavaScript to run this app.</noscript>
<div id="Login_div">
    <div id="Logo"><h1>登录</h1></div>
    <input id="csrf" type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input id="remember" type="hidden" name="remember-me" value="true"/>
    <div id="Login"></div>
</div>
<script>!function (e) {
    function r(r) {
        for (var n, i, a = r[0], c = r[1], l = r[2], s = 0, p = []; s < a.length; s++) i = a[s], Object.prototype.hasOwnProperty.call(o, i) && o[i] && p.push(o[i][0]), o[i] = 0;
        for (n in c) Object.prototype.hasOwnProperty.call(c, n) && (e[n] = c[n]);
        for (f && f(r); p.length;) p.shift()();
        return u.push.apply(u, l || []), t()
    }

    function t() {
        for (var e, r = 0; r < u.length; r++) {
            for (var t = u[r], n = !0, a = 1; a < t.length; a++) {
                var c = t[a];
                0 !== o[c] && (n = !1)
            }
            n && (u.splice(r--, 1), e = i(i.s = t[0]))
        }
        return e
    }

    var n = {}, o = {1: 0}, u = [];

    function i(r) {
        if (n[r]) return n[r].exports;
        var t = n[r] = {i: r, l: !1, exports: {}};
        return e[r].call(t.exports, t, t.exports, i), t.l = !0, t.exports
    }

    i.e = function (e) {
        var r = [], t = o[e];
        if (0 !== t) if (t) r.push(t[2]); else {
            var n = new Promise((function (r, n) {
                t = o[e] = [r, n]
            }));
            r.push(t[2] = n);
            var u, a = document.createElement("script");
            a.charset = "utf-8", a.timeout = 120, i.nc && a.setAttribute("nonce", i.nc), a.src = function (e) {
                return i.p + "static/js/" + ({}[e] || e) + "." + {3: "42d1248c"}[e] + ".chunk.js"
            }(e);
            var c = new Error;
            u = function (r) {
                a.onerror = a.onload = null, clearTimeout(l);
                var t = o[e];
                if (0 !== t) {
                    if (t) {
                        var n = r && ("load" === r.type ? "missing" : r.type), u = r && r.target && r.target.src;
                        c.message = "Loading chunk " + e + " failed.\n(" + n + ": " + u + ")", c.name = "ChunkLoadError", c.type = n, c.request = u, t[1](c)
                    }
                    o[e] = void 0
                }
            };
            var l = setTimeout((function () {
                u({type: "timeout", target: a})
            }), 12e4);
            a.onerror = a.onload = u, document.head.appendChild(a)
        }
        return Promise.all(r)
    }, i.m = e, i.c = n, i.d = function (e, r, t) {
        i.o(e, r) || Object.defineProperty(e, r, {enumerable: !0, get: t})
    }, i.r = function (e) {
        "undefined" != typeof Symbol && Symbol.toStringTag && Object.defineProperty(e, Symbol.toStringTag, {value: "Module"}), Object.defineProperty(e, "__esModule", {value: !0})
    }, i.t = function (e, r) {
        if (1 & r && (e = i(e)), 8 & r) return e;
        if (4 & r && "object" == typeof e && e && e.__esModule) return e;
        var t = Object.create(null);
        if (i.r(t), Object.defineProperty(t, "default", {
            enumerable: !0,
            value: e
        }), 2 & r && "string" != typeof e) for (var n in e) i.d(t, n, function (r) {
            return e[r]
        }.bind(null, n));
        return t
    }, i.n = function (e) {
        var r = e && e.__esModule ? function () {
            return e.default
        } : function () {
            return e
        };
        return i.d(r, "a", r), r
    }, i.o = function (e, r) {
        return Object.prototype.hasOwnProperty.call(e, r)
    }, i.p = "./", i.oe = function (e) {
        throw console.error(e), e
    };
    var a = this.webpackJsonplogin = this.webpackJsonplogin || [], c = a.push.bind(a);
    a.push = r, a = a.slice();
    for (var l = 0; l < a.length; l++) r(a[l]);
    var f = c;
    t()
}([])</script>
<script src="./static/js/2.15eb7ab6.chunk.js"></script>
<script src="./static/js/main.1e9017a3.chunk.js"></script>
</body>
</html>