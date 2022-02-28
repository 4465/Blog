<%--
  Created by IntelliJ IDEA.
  User: 15271
  Date: 2022/2/28
  Time: 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8" />
    <title>示例</title>
    <link rel="stylesheet" href="editormd/css/editormd.css" />
    <link rel="stylesheet" href="editormd/css/fonts/fontawesome-webfont.woff2">
</head>
<body>
<div id="layout">
    <header>
        <h1>editor.md示例</h1>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </header>
    <div id="test-editormd">
        <textarea style="display:none;" class="form-control" id="editormd" name="editormd"></textarea>
    </div>
</div>
<script src="editormd/examples/js/jquery.min.js"></script>
<script src="editormd/editormd.js"></script>
<script type="text/javascript">
    var testEditor;
    $(function() {//Editor初始化：
        testEditor = editormd("test-editormd", {
            width   : "90%",
            height  : 640,
            syncScrolling : "single",
            // theme : "dark",
            path    : "editormd/lib/", //依赖lib文件夹路径
            //这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单
            saveHTMLToTextarea : true,
            saveHTMLToTextarea : true, // 保存 HTML 到 Textarea，true表示转化为html格式的内容也同样提交到后台
            toolbarAutoFixed:true,//工具栏自动固定定位的开启与禁用
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "imageUpload",
        });
    });
</script>
</body>
</html>
