function checkName() {
    const value = document.getElementById("name").value;
    if (value === "") {
        document.getElementsByClassName("status")[0].src = "./img/error.gif";
        return false;
    } else {
        document.getElementsByClassName("status")[0].src = "./img/okay.gif";
        return true;
    }
}

function checkPassword() {
    const value = document.getElementById("password").value;
    if (value === "") {
        document.getElementsByClassName("status")[1].src = "./img/error.gif";
        return false;
    } else {
        document.getElementsByClassName("status")[1].src = "./img/okay.gif";
        return true;
    }
}

function checkEmail() {
    const regExp = /\w+([-+.]\w+)*@\w+([-.]\w+)*.\w+([-.]\w+)*/;
    const value = document.getElementById("email").value;
    if (regExp.test(value)) {
        document.getElementsByClassName("status")[2].src = "./img/okay.gif";
        return true;
    } else {
        document.getElementsByClassName("status")[2].src = "./img/error.gif";
        return false;
    }
}

/**
 * 核实验证码的ajax函数
 */
function checkCode() {
    //1.创建ajax引擎对象
    let ajaxObject;
    if (window.XMLHttpRequest) {
        //  新浏览器
        ajaxObject = new XMLHttpRequest();
    } else {
        //IE5、IE6
        ajaxObject = new ActiveXObject("Microsoft.XMLHTTP");
    }
//    2.创建请求
    ajaxObject.open("post", "CodeServlet", true);
//    post提交ajax请求一定要设置请求头部信息
    ajaxObject.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    const value = document.getElementById("input").value;
    // 3.发送请求
    ajaxObject.send("input=" + value);
    debugger;
    // 4.调用回调函数
    ajaxObject.onreadystatechange = function () {
        if (ajaxObject.readyState === 4 && ajaxObject.status === 200) {
            if ("1" === ajaxObject.responseText) {
                document.getElementsByClassName("status")[3].src = "./img/okay.gif";
            } else {
                document.getElementsByClassName("status")[3].src = "./img/error.gif";
            }
        }
    }
}

/**
 * 切换验证码的函数
 */
function cannotSee() {
    document.getElementById("code").src = "CodeServlet?refresh=" + new Date().getTime();
}

/**
 * 提交时校验所有返回值
 * @returns {boolean|void}
 */
function check() {
    return checkName() && checkPassword() && checkEmail() && checkCode();
}