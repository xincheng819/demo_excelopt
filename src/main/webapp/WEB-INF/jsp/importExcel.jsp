<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>demo excel opt</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" crossorigin="anonymous">--%>
    <%--<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/4.5.1/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />--%>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- 可选的Bootstrap主题文件（一般不使用） -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/4.5.1/css/fileinput.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-fileinput/4.5.1/js/fileinput.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-fileinput/4.5.1/js/locales/zh.js"></script>
    <script type="text/javascript">
        $(document).on('ready', function() {
            $("#input-folder-2").fileinput({
                language:"zh",
                uploadUrl:" /excelUpload/upload", //上传的地址
                uploadExtraData:{},
                showRemove :true, //显示移除按钮
                showPreview :false, //是否显示预览
                showCaption:true,//是否显示标题
                browseLabel: 'Select Folder...',
                // previewFileIcon: '<i class="fas fa-file"></i>',
                maxFileCount:10, //表示允许同时上传的最大文件个数
                enctype:'multipart/form-data',
                validateInitialCount:true,
                msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
                allowedPreviewTypes: null, // set to empty, null or false to disable preview for all types
                allowedFileExtensions: ['xls', 'xlsx'],
                previewFileIconSettings: {
                    'xls': '<i class="fas fa-file-excel text-success"></i>',
                    'xlsx': '<i class="fas fa-file-excel text-success"></i>'
                },
                previewFileExtSettings: {
                    'xls': function(ext) {
                        return ext.match(/(xls|xlsx)$/i);
                    }
                }
            }).on("fileuploaded", function (event, data, previewId, index){
                var res = data.response;
                $("#errorBlock").text("Success!  "+res.res);
                console.log(res.res);
            });
        });
    </script>
</head>
<body>
<div>
    <label for="input-folder-2">Upload All Files From Folder</label>
    <div class="file-loading">
        <input id="input-folder-2" name="input-folder-2[]" type="file" multiple="multiple" >
    </div>
    <div id="errorBlock" class="help-block"></div>
</div>

</body>
</html>
