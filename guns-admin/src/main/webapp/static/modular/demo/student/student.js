/**
 * 字典管理初始化
 */
var Student = {
    id: "StudentTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Student.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '学号', field: 'no', align: 'center', valign: 'middle', sortable: false},
        {title: '姓名', field: 'name', align: 'center', valign: 'middle', sortable: false},
        {title: '备注', field: 'age', align: 'center', valign: 'middle', sortable: false}];
};

/**
 * 检查是否选中
 */
Student.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        Dict.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加字典
 */
Student.openAddDict = function () {
    var index = layer.open({
        type: 2,
        title: '添加字典',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/dict/dict_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看字典详情
 */
Student.openDictDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '字典详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/dict/dict_edit/' + Dict.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除字典
 */
Student.delete = function () {
    if (this.check()) {

        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/student/delete", function (data) {
                Feng.success("删除成功!");
                Student.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("dictId", Student.seItem.id);
            ajax.start();
        };

        Feng.confirm("是否刪除字典 " + Student.seItem.name + "?", operation);
    }
};

/**
 * 查询字典列表
 */
Student.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Student.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Student.initColumn();
    var table = new BSTable(Student.id, "/demo/student/list", defaultColunms);
    table.setPaginationType("client");
    Student.table = table.init();
});
