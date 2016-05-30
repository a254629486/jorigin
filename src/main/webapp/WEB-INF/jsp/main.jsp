<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
	<head>
	<meta charset="utf-8">
	<title>欢迎来到jorigin</title>
	<script src="<%=basePath%>static/js/jquery.js"></script>
	<script type="text/javascript">
	$(document).ready(function(e){
			$('input').change(function(e){
					var red = $('#red').val();
					var green = $('#green').val();
					var blue = $('#blue').val();
					
					var value = $(this).val();
					$(this).next().html(value);
					
					$('body').css('background-color','rgb('+red+','+green+','+blue+')');
				});
				
				
				$('#nav li').click(function(e){
					$('.liclick').removeClass('liclick');
					$(this).addClass('liclick');
				});
				
				var color = ['#B8D329','#C0EBF7','#B9D329','#69BCF3','#79D9F3','#FA5F94','#ACD180','#FAB4CC','#FFAE5B'];
				$('#nav li').append('<span>');
				$('#nav span').each(function(index,element){
					$(this).css('background-color',color[index]);
				})
				//移动到li上的时候颜色升起
				$('#nav li').hover(function(){
					$(this).children('span').animate({'top':-38},200);	
					var index = $(this).index();
					$('audio').get(index).play();
				},function(){
					$(this).children('span').animate({'top':0},200);
					var index = $(this).index();
					$('audio').get(index).pause();
				});
		});
</script>
	<style type="text/css">
#nav {
	list-style-type: none; /*去掉无需列表前面的点*/
	margin: 50px auto 0px; /**/
	width: 950; /**/
	height: 38px;
	color: #333;
	font-size: 14px;
	padding: 0px;
	overflow: hidden;
}
#nav li {
	width: 105px;
	height: 36px;
	float: left;
	text-align: center;
	line-height: 38px;
	border-top: #C9CBCE solid 1px;
	border-left: #C9CBCE solid 1px;
	border-bottom: #C9CBCE solid 1px;
	cursor: pointer;
}
#nav li:last-child {
	border-right: #C9CBCE solid 1px;
}
#nav .liclick {
	border-top: #54B82A solid 2px;
	border-bottom: none;
}
#nav span {
	width: 100%;
	height: 38px;
	display: block;
	position: relative;
	z-index: -1;
}
</style>
	</hedl>
	<body>
<ul id="nav">
      <li class="liclick">主页</li>
      <li>电影</li>
      <li>历史</li>
      <li>生活</li>
      <li>军事</li>
      <li>女人</li>
      <li>男人</li>
      <li>电商</li>
      <li>机器</li>
    </ul>
<br>
<form>
      邮箱：
      <input type="email" name ="myemail" required placeholder="qingshur">
      <br>
      日期:
      <input type="date" name="mydate">
      <br>
      颜色：
      <input type="color">
      <br>
      地址：
      <select>
    <optgroup label="北京">
        <option>西城</option>
        <option>东城</option>
        </optgroup>
    <optgroup label="天津">
        <option>河东</option>
        <option>河西</option>
        </optgroup>
  </select>
      车型：
      <input type="text" list="car">
      <datalist id="car">
    <option>奥迪</option>
    <option>奥迪</option>
    <option>奥迪</option>
  </datalist>
      <br>
      <input type="submit" value="提交">
    </form>
红色：
<input type="range" id="red" min="0"  max="255" value="0">
<span>255</span><br>
绿色：
<input type="range" id="green" min="0"  max="255" value="0">
<span>255</span><br>
蓝色：
<input type="range" id="blue" min="0"  max="255" value="0">
<span>255</span><br>
<audio src="11.mp3" controls>不支持播放</audio>
<audio  controls>
      <source src="2.mp3" >
      <source src="3.mp3">
    </audio>
<video autoplay controls>
      <source src="11.mp4">
    </video>
</body>
</html>