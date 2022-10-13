<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="/sseda/js/jquery-3.6.1.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>    
<link rel="stylesheet" href="/sseda/css/new.css">    
<script src="/sseda/js/newq.js"></script>



<div class="cont_select_center">
  <!-- Custom select structure --> 
<div class="select_mate" data-mate-select="active" >
<select name="" onchange="" onclick="return false;" id="">
<option value=""  >all</option>
<option value="1">title</option>
<option value="2" >nickname</option>
<option value="3">content</option>
  </select>
<p class="selecionado_opcion"  onclick="open_select(this)" ></p><span onclick="open_select(this)" class="icon_select_mate" ><svg fill="#000000" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
    <path d="M7.41 7.84L12 12.42l4.59-4.58L18 9.25l-6 6-6-6z"/>
    <path d="M0-.75h24v24H0z" fill="none"/>
</svg></span>
<div class="cont_list_select_mate">
  <ul class="cont_select_int">  </ul> 
</div>
</div>
</div>
	