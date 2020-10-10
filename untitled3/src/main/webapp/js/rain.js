function deleteById(arg) {
    const result = confirm("确定要删除这条记录吗?");
    if (result) {
        window.location.href = "DeleteByIdServlet?id=" + arg;
    }
}