// JavaScript Document

//引用 全局
document.write('<script type="text/javascript" src="/jscript/more_sort.js"><\/script>');
document.write('<script type="text/javascript" src="/jscript/public.js"><\/script>');
document.write('<script type="text/javascript" src="/jscript/ajax.js"><\/script>');
document.write('<script type="text/javascript" src="/jscript/new_common.js"><\/script>');
document.write('<script type="text/javascript" src="/jscript/swfobject.js"><\/script>');
document.write('<script type="text/javascript" src="/jscript/domtab.js"><\/script>');
document.write('<script type="text/javascript" src="/templates/jscript/temp_public.js"><\/script>');
//引用 功能
document.write('<script type="text/javascript" src="/templates/jscript/ddsmoothmenu.js"><\/script>');

//分类
$(document).ready(function () {
    $(function () {
        // $(".tempateSortSearch .content li:gt(0)").hide(); //隐藏除了内容区第一个li
        $(".sortnav dl dd:gt(0)").hide(); //隐藏
        $(".sortnav dl dt").click(function () {  //给选项卡绑定单击事件
            $(this).addClass("select")    //高亮显示单击后的按钮
              .siblings().removeClass("select");    //去掉同辈元素的高亮         
            var $index = $(".sortnav dl dt").index(this);    //获取当前单击的li元素在全部li元素中的索引
            $(".sortnav dl dd").eq($index).show(1000)   //显示对应的内容
            //.siblings().hide();
            .siblings(".sortnav dl dd").hide();
        }).hover(function () {
            $(this).addClass("hover");
        }, function () {
            $(this).removeClass("hover")
        })
    })
});











