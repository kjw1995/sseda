<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/menu.css">
<link rel="stylesheet" href="/css/footer.css">
<link rel="stylesheet" href="/css/mypage_detail.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/js/mypage_detail.js"></script>
</head>
<body>
<input type="hidden" class="maincate" value="${category}">
<input type="hidden" class="myid" value="${id}">
<div class="app-container">
  <div class="sidebar">
    <div class="sidebar-header">
      <div class="app-icon">
        <svg viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg"><path fill="currentColor" d="M507.606 371.054a187.217 187.217 0 00-23.051-19.606c-17.316 19.999-37.648 36.808-60.572 50.041-35.508 20.505-75.893 31.452-116.875 31.711 21.762 8.776 45.224 13.38 69.396 13.38 49.524 0 96.084-19.286 131.103-54.305a15 15 0 004.394-10.606 15.028 15.028 0 00-4.395-10.615zM27.445 351.448a187.392 187.392 0 00-23.051 19.606C1.581 373.868 0 377.691 0 381.669s1.581 7.793 4.394 10.606c35.019 35.019 81.579 54.305 131.103 54.305 24.172 0 47.634-4.604 69.396-13.38-40.985-.259-81.367-11.206-116.879-31.713-22.922-13.231-43.254-30.04-60.569-50.039zM103.015 375.508c24.937 14.4 53.928 24.056 84.837 26.854-53.409-29.561-82.274-70.602-95.861-94.135-14.942-25.878-25.041-53.917-30.063-83.421-14.921.64-29.775 2.868-44.227 6.709-6.6 1.576-11.507 7.517-11.507 14.599 0 1.312.172 2.618.512 3.885 15.32 57.142 52.726 100.35 96.309 125.509zM324.148 402.362c30.908-2.799 59.9-12.454 84.837-26.854 43.583-25.159 80.989-68.367 96.31-125.508.34-1.267.512-2.573.512-3.885 0-7.082-4.907-13.023-11.507-14.599-14.452-3.841-29.306-6.07-44.227-6.709-5.022 29.504-15.121 57.543-30.063 83.421-13.588 23.533-42.419 64.554-95.862 94.134zM187.301 366.948c-15.157-24.483-38.696-71.48-38.696-135.903 0-32.646 6.043-64.401 17.945-94.529-16.394-9.351-33.972-16.623-52.273-21.525-8.004-2.142-16.225 2.604-18.37 10.605-16.372 61.078-4.825 121.063 22.064 167.631 16.325 28.275 39.769 54.111 69.33 73.721zM324.684 366.957c29.568-19.611 53.017-45.451 69.344-73.73 26.889-46.569 38.436-106.553 22.064-167.631-2.145-8.001-10.366-12.748-18.37-10.605-18.304 4.902-35.883 12.176-52.279 21.529 11.9 30.126 17.943 61.88 17.943 94.525.001 64.478-23.58 111.488-38.702 135.912zM266.606 69.813c-2.813-2.813-6.637-4.394-10.615-4.394a15 15 0 00-10.606 4.394c-39.289 39.289-66.78 96.005-66.78 161.231 0 65.256 27.522 121.974 66.78 161.231 2.813 2.813 6.637 4.394 10.615 4.394s7.793-1.581 10.606-4.394c39.248-39.247 66.78-95.96 66.78-161.231.001-65.256-27.511-121.964-66.78-161.231z"/></svg>
      </div>
    </div>
    <ul class="sidebar-list">
      <li class="sidebar-list-item">
        <a href="/">
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home"><path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"/><polyline points="9 22 9 12 15 12 15 22"/></svg>
          <span>Home</span>
        </a>
      </li>
      <li class="sidebar-list-item item-li">
        <a href="" id="a_item">
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-bag"><path d="M6 2L3 6v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V6l-3-4z"/><line x1="3" y1="6" x2="21" y2="6"/><path d="M16 10a4 4 0 0 1-8 0"/></svg>
          <span>아이템</span>
        </a>
      </li>
      <li class="sidebar-list-item board-li">
        <a href="" id="a_board">
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-bag"><path d="M6 2L3 6v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V6l-3-4z"/><line x1="3" y1="6" x2="21" y2="6"/><path d="M16 10a4 4 0 0 1-8 0"/></svg>
          <span>게시글</span>
        </a>
      </li>
      <li class="sidebar-list-item reply-li">
        <a href="" id="a_reply">
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-bag"><path d="M6 2L3 6v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V6l-3-4z"/><line x1="3" y1="6" x2="21" y2="6"/><path d="M16 10a4 4 0 0 1-8 0"/></svg>
          <span>댓글</span>
        </a>
      </li>
        <li class="sidebar-list-item">
        <a href="#">
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-bag"><path d="M6 2L3 6v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V6l-3-4z"/><line x1="3" y1="6" x2="21" y2="6"/><path d="M16 10a4 4 0 0 1-8 0"/></svg>
          <span>관심목록</span>
        </a>
      </li>
        <li class="sidebar-list-item">
        <a href="#">
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-bag"><path d="M6 2L3 6v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V6l-3-4z"/><line x1="3" y1="6" x2="21" y2="6"/><path d="M16 10a4 4 0 0 1-8 0"/></svg>
          <span>매칭</span>
        </a>
      </li>
        <li class="sidebar-list-item">
        <a href="#">
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-bag"><path d="M6 2L3 6v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V6l-3-4z"/><line x1="3" y1="6" x2="21" y2="6"/><path d="M16 10a4 4 0 0 1-8 0"/></svg>
          <span>문의현황</span>
        </a>
      </li>
      <li class="sidebar-list-item">
        <a href="#">
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-bell"><path d="M18 8A6 6 0 0 0 6 8c0 7-3 9-3 9h18s-3-2-3-9"/><path d="M13.73 21a2 2 0 0 1-3.46 0"/></svg>
          <span>쪽지</span>
        </a>
      </li>
    </ul>
    <div class="account-info">
      <div class="account-info-picture">
        <img src="../img/mentee.jpg" alt="Account">
      </div>
      <div class="account-info-name">${id}</div>
      <button class="account-info-more">
      	<a href="/mem/changeuser?id=${id}">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-horizontal"><circle cx="12" cy="12" r="1"/><circle cx="19" cy="12" r="1"/><circle cx="5" cy="12" r="1"/></svg>
        </a>
      </button>
    </div>
  </div>
  <div class="app-content">
    <div class="app-content-header">
      <h1 class="app-content-headerText"></h1>
      <button class="mode-switch" title="Switch Theme">
        <svg class="moon" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" width="24" height="24" viewBox="0 0 24 24">
          <defs></defs>
          <path d="M21 12.79A9 9 0 1111.21 3 7 7 0 0021 12.79z"></path>
        </svg>
      </button>
      <button class="app-content-headerButton">Add Product</button>
    </div>
    <div class="app-content-actions">
      <!-- <input class="search-bar" placeholder="Search..." type="text"> -->
      <div class="app-content-actions-wrapper">
       <!--  <div class="filter-button-wrapper">
          <button class="action-button filter jsFilter"><span>Filter</span><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-filter"><polygon points="22 3 2 3 10 12.46 10 19 14 21 14 12.46 22 3"/></svg></button>
          <div class="filter-menu">
            <label>Category</label>
            <select>
              <option>All Categories</option>
              <option>Furniture</option>                     <option>Decoration</option>
              <option>Kitchen</option>
              <option>Bathroom</option>
            </select>
            <label>Status</label>
            <select>
              <option>All Status</option>
              <option>Active</option>
              <option>Disabled</option>
            </select>
            <div class="filter-menu-buttons">
              <button class="filter-button reset">
                Reset
              </button>
              <button class="filter-button apply">
                Apply
              </button>
            </div>
          </div>
        </div> -->
        <button class="action-button list active" title="List View">
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-list"><line x1="8" y1="6" x2="21" y2="6"/><line x1="8" y1="12" x2="21" y2="12"/><line x1="8" y1="18" x2="21" y2="18"/><line x1="3" y1="6" x2="3.01" y2="6"/><line x1="3" y1="12" x2="3.01" y2="12"/><line x1="3" y1="18" x2="3.01" y2="18"/></svg>
        </button>
        <button class="action-button grid" title="Grid View">
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-grid"><rect x="3" y="3" width="7" height="7"/><rect x="14" y="3" width="7" height="7"/><rect x="14" y="14" width="7" height="7"/><rect x="3" y="14" width="7" height="7"/></svg>
        </button>
      </div>
    </div>
    <div class="products-area-wrapper tableView">
      <!-- <div class="products-header">
        <div class="cell-font image">제목
          <button class="sort-button">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 512 512"><path fill="currentColor" d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z"/></svg>
          </button>
        </div>
        <div class="cell-font category">카테고리<button class="sort-button">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 512 512"><path fill="currentColor" d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z"/></svg>
          </button></div>
        <div class="cell-font status-cell">매칭여부<button class="sort-button">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 512 512"><path fill="currentColor" d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z"/></svg>
          </button></div>
        <div class="cell-font sales">조회수<button class="sort-button">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 512 512"><path fill="currentColor" d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z"/></svg>
          </button></div>
        <div class="cell-font stock">가격<button class="sort-button">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 512 512"><path fill="currentColor" d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z"/></svg>
          </button></div>
        <div class="cell-font price">공개여부<button class="sort-button">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 512 512"><path fill="currentColor" d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z"/></svg>
          </button></div>
      </div> -->
     
    
      <!-- <div class="products-row"> -->
        <%-- <button class="cell-more-button">
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical"><circle cx="12" cy="12" r="1"/><circle cx="12" cy="5" r="1"/><circle cx="12" cy="19" r="1"/></svg>
        </button> --%>
          <!-- <div class="product-cell image"> -->
	          <%-- <c:if test="${my.cfcheck eq 'O'}">
	          	<!-- <img src="https://images.unsplash.com/photo-1555041469-a586c61ea9bc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1950&q=80" alt="product"> -->
	          	<img src="../img/mentor.jpg" alt="product">
	          </c:if>
	          
	          <c:if test="${my.cfcheck eq 'I'}">
	          	<!-- <img src="https://images.unsplash.com/photo-1555041469-a586c61ea9bc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1950&q=80" alt="product"> -->
	          	<img src="../img/mentee.jpg" alt="product">
	          </c:if> --%>
	          
            <!-- <span class="datatitle"></span> -->
          <!-- </div> -->
        <!-- <div class="product-cell category">
        	<span class="cell-label">카테고리:</span>
       	</div> -->
       	
       	<!-- <div class="product-cell status-cell">
       		 <div class="product-cell status-cell">
	          	<span class="cell-label">매칭:</span>
	         </div>
       	</div> -->
       	
        <%-- <div class="product-cell sales"><span class="cell-label">조회수:</span>${my.count}</div>
        <div class="product-cell stock"><span class="cell-label">가격:</span>${my.price}</div>
        <div class="product-cell price"><span class="cell-label">공개여부:</span>${my.open}</div> --%>
        <!-- </div> -->
      
      
      <%-- <div class="products-row">
        <button class="cell-more-button">
          <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical"><circle cx="12" cy="12" r="1"/><circle cx="12" cy="5" r="1"/><circle cx="12" cy="19" r="1"/></svg>
        </button>
          <div class="product-cell image">
            <img src="https://images.unsplash.com/photo-1484154218962-a197022b5858?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8a2l0Y2hlbnxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=900&q=60" alt="product">
            <span>Lou</span>
          </div>
        <div class="product-cell category"><span class="cell-label">Category:</span>소설</div>
        <div class="product-cell status-cell ">
          <span class="cell-label">Status:</span>
          <span class="status disabled">매칭중</span>
        </div>
        <div class="product-cell sales"><span class="cell-label">Sales:</span>6</div>
        <div class="product-cell stock"><span class="cell-label">Stock:</span>46</div>
        <div class="product-cell price"><span class="cell-label">Price:</span>$710</div>
      </div> --%>
      
         <%-- <div class="page-div">
			<div class="page-sondiv">
				<c:forEach var="x" begin="${page.start}" end="${page.end}">
					<button class="mypage-btn" value="${x}">${x}</button>
				</c:forEach>
			</div>
	    </div>      --%>
	   
   </div> 
 </div>
</div>
</body>
<script>
$(document).ready(function(){
	
	if($(".maincate").val() == "item") {
		
	}
	
	$(".jsFilter").on("click", function () {
	  $(".filter-menu").classList.toggle("active");
	});
	
	$(".grid").on("click", function () {
	  $(".list").removeClass("active");
	  $(".grid").addClass("active");
/* 	  $(".list").classList.remove("active");
	  $(".grid").classList.add("active"); */
	  $(".products-area-wrapper").addClass("gridView");
/* 	  $(".products-area-wrapper").classList.add("gridView"); */
	  $(".products-area-wrapper")
/* 	  document
	    .querySelector(".products-area-wrapper") */
	    .removeClass("tableView");
/* 	    .classList.remove("tableView"); */
	});
	
	$(".list").on("click", function () {
	  $(".list").addClass("active");
/* 	  $(".list").classList.add("active"); */
	  $(".grid").removeClass("active");
/* 	  $(".grid").classList.remove("active"); */
	  /* $(".products-area-wrapper").classList.remove("gridView"); */
	  $(".products-area-wrapper").removeClass("gridView");
	  $(".products-area-wrapper").addClass("tableView");
/* 	  $(".products-area-wrapper").classList.add("tableView"); */
	});
	
	$(".mode-switch").on("click", function () {
	  document.documentElement.classList.toggle("light");
	  $(".mode-switch").addClass("active");  
	});
	
/* 데이터 리스트 */
/* $(".product-cell image")
$(".product-cell category")
$(".status disabled")
$(".product-cell sales")
$(".product-cell sales")
$(".product-cell price")        
$(".status active") */
var id = $(".myid").val();
var cate = $(".maincate");
var curPage = 1;

varlist(id,cate.val(),1);

	function varlist(id,cate,currentPage) {
		
		console.log("페이지 확인 = " + currentPage);
		console.log("아이디 확인 = " + id);
		console.log("카테고리 확인 = " + cate);
		
		mypage.list({id:id, cate:cate, currentPage:currentPage}, function(data){
			
			/* 데이터 확인 
			for(var i=0, len=data.mylist.item.length || 0; i < len; i++) {
				console.log(data.mylist.item[i]);
			} */
			
			/* 데이터가 없는경우 
			if(data.mylist.item == null || data.mylist.item.length == 0) {
				console.log("데이터가 존재하지 않습니다.");
				$(".products-row").html("데이터가 존재하지 않습니다.");
				return;
			} */
			
			
			
			/* 데이터가 있는경우 */
			if(data.mylist.item != null) {
				
			if(cate == "item") {
				var str = "";	
				str += "<div class='products-header'>";
				str += "<div class='cell-font image'>제목</div>";
			 	str += "<div class='cell-font category'>카테고리</div>";
		        str += "<div class='cell-font status-cell'>매칭여부</div>";
		        str += "<div class='cell-font sales'>조회수</div>";
		        str += "<div class='cell-font stock'>가격</div>";
		        str += "<div class='cell-font price'>공개여부</div>";
		        str += "</div>";
				
				for(var i=0, len = data.mylist.item.length || 0; i < len; i++) {
					str += "<div class='products-row'>";
					str += "<div class='product-cell image'>";
					/* 제목 */
					if(data.mylist.item[i].cfcheck == "O") {
						str += "<img src='/img/mentor.jpg' alt='product'>";
					} else if(data.mylist.item[i].cfcheck == "I") {
						str += "<img src='/img/mentee.jpg' alt='product'>";
					}
						str += "<span class='datatitle'>";
						str += data.mylist.item[i].title;
						str += "</span>";
						str += "</div>";
						
					
						/* 카테고리 */
						str += "<div class='product-cell category'>";
						str += "<span class='cell-label'>카테고리:</span>";
						str += data.mylist.item[i].code;
						str += "</div>";
						
						/* 매칭여부 */
						str += "<div class='product-cell status-cell'>";
						str += "<span class='cell-label'>매칭:</span>";
						
						if(data.mylist.item[i].matching == "N") {
							str += "<span class='status disabled'>매칭중</span>";
						}
						
						if(data.mylist.item[i].matching == "Y") {
							str += "<span class='status active'>매칭완료</span>";
						}
						
						str += "</div>";
						
						/* 조회수 */
						str += "<div class='product-cell sales'>";
						str += "<span class='cell-label'>조회수:</span>";
						str += data.mylist.item[i].count;
						str += "</div>";
						
						/* 가격 */
						str += "<div class='product-cell stock'>";
						str += "<span class='cell-label'>가격:</span>";
						str += data.mylist.item[i].price;
						str += "</div>";

						/* 공개여부 */
						str += "<div class='product-cell price'>";
						str += "<span class='cell-label'>공개여부:</span>";
						str += data.mylist.item[i].open;
						str += "</div>";
						str += "</div>";
					}
				/* 리스트 버튼 */
				str += "<div class='page-div'>";
				str += "<div class='page-sondiv'>";
				str += "</div>";
				str += "</div>";
								
				$(".tableView").html(str);
				console.log("레코드수 = " + data.total);
				varPage(data.total,curPage);
			}
		} else if(data.mylist.board != null) {
			
				if(cate == "board") {
					var board = "";	
					
					board += "<div class='products-header'>";
					board += "<div class='cell-font image'>제목</div>";
					board += "<div class='cell-font category'>키워드</div>";
					board += "<div class='cell-font sales'>조회수</div>";
					board += "<div class='cell-font price'>작성일자</div>";
					board += "</div>";
					for(var i=0; i < data.mylist.board.length; i++) {
						
						/* 제목 */
						board += "<div class='products-row'>";
						board += "<div class='product-cell image'>";
						board += "<img src='/img/mentee.jpg' alt='product'>";
						board += "<span class='datatitle'>";
						board += data.mylist.board[i].title;
						board += "</span>";
						board += "</div>";
						
						/* 키워드 */
						board += "<div class='product-cell category'>";
						board += "<span class='cell-label'>키워드:</span>";
						board += data.mylist.board[i].keyword;
						board += "</div>";
						
						/* 조회수 */
						board += "<div class='product-cell sales'>";
						board += "<span class='cell-label'>조회수:</span>";
						board += data.mylist.board[i].count;
						board += "</div>";
						
						/* 작성일자 */
						board += "<div class='product-cell price'>";
						board += "<span class='cell-label'>작성일자:</span>";
						board += data.mylist.board[i].wdate;
						board += "</div>";
						board += "</div>";
						
					}
				/* 리스트 버튼 */
				board += "<div class='page-div'>";
				board += "<div class='page-sondiv'>";
				board += "</div>";
				board += "</div>";
								
				$(".tableView").html(board);
				console.log("레코드수 = " + data.total);
				varPage(data.total,curPage);
			}
			
		} else if(data.mylist.reply != null) {
			if(cate == "reply") {
				var reply = "";	
			
				reply += "<div class='products-header'>";
				reply += "<div class='cell-font image'>게시글제목</div>";
				reply += "<div class='cell-font category'>댓글내용</div>";
				reply += "<div class='cell-font sales'>작성일자</div>";
				reply += "</div>";
				for(var i = 0; i < data.mylist.reply.length; i++) {
					
					/* 게시글제목 */
					reply += "<div class='products-row'>";
					reply += "<div class='product-cell image'>";
					reply += "<img src='/img/mentee.jpg' alt='product'>";
					reply += "<span class='datatitle'>";
					reply += data.mylist.reply[i].board_title;
					reply += "</span>";
					reply += "</div>";
					
					/* 댓글내용 */
					reply += "<div class='product-cell category'>";
					reply += "<span class='cell-label'>댓글내용:</span>";
					reply += data.mylist.reply[i].content;
					reply += "</div>";
					
					/* 작성일자 */
					reply += "<div class='product-cell sales'>";
					reply += "<span class='cell-label'>조회수:</span>";
					reply += data.mylist.reply[i].wdate;
					reply += "</div>";
					reply += "</div>";
				}
				
				/* 리스트 버튼 */
				reply += "<div class='page-div'>";
				reply += "<div class='page-sondiv'>";
				reply += "</div>";
				reply += "</div>";
								
				$(".tableView").html(reply);
				console.log("레코드수 = " + data.total);
				varPage(data.total,curPage);
				
			}
		}
			
			
		});
		
	}
	
		
		/* 카테고리에 따른 페이지 출력 */
		function varPage(varRecords) {
			var btn = "";
			var endPage = Math.ceil(curPage/15.0)*Math.ceil(varRecords/15.0);
			var startPage = endPage - (Math.ceil(varRecords/15.0)-1);
			
			var prev = curPage > 1;
			var next = false;
			
			console.log("curPage = " + curPage);
			console.log("startPage = " + startPage);
			console.log("prev = " + prev);
			
			if(endPage * Math.ceil(varRecords/15.0) >= varRecords) {
				endPage = Math.ceil(varRecords/15.0);
			}
			
			if(endPage * 15 < varRecords) {
				next = true;
			}
			
			/* 이전페이지 */
			if(prev) {
				btn += "<button class='mypage-btn' value='" + (curPage - 1) + "'>prev</button>";
			}
			
			for(var i = startPage; i <= endPage; i++) {
				btn += "<button class='mypage-btn' id ='btn-"+i+"' value='" + i + "'>" + i + "</button>";
			}
			
			/* 다음페이지 */
			if(next) {
				btn += "<button class='mypage-btn' value='" + (endPage + 1) + "'>next</button>";
			}
			
			$(".page-sondiv").html(btn);
	}
	
	/* 리스트 페이지 번호 클릭시 */
	$(document).on("click",".mypage-btn",function(){
		console.log("페이지변환");
		var clickPage = $(this).val();
		console.log("curPage = " + clickPage + "(clickPage)");
		curPage = clickPage;
		varlist(id,cate.val(),curPage); 
	});

	
	/* 사이드바 클릭시 */
	$("#a_item").on("click",function(e){
		e.preventDefault();
		cate.val("item");
		$(".sidebar-list-item").removeClass("active");
		$(".item-li").addClass("active");
		$(".app-content-headerText").html("아이템");
		varlist(id,"item",1);
		console.log("item a")
	});
	
	$("#a_board").on("click",function(e){
		e.preventDefault();
		cate.val("board");
		$(".sidebar-list-item").removeClass("active");
		$(".board-li").addClass("active");
		$(".app-content-headerText").html("게시글");
		varlist(id,"board",1);
		console.log("board a");
	});
	
	$("#a_reply").on("click",function(e){
		e.preventDefault();
		cate.val("reply");
		$(".sidebar-list-item").removeClass("active");
		$(".reply-li").addClass("active");
		$(".app-content-headerText").html("댓글");
		varlist(id,"reply",1);
		console.log("reply a");
	});
		
	
	
	/* Mypage main 에서 넘어올시 */
	var maincate = '<c:out value="${category}" />';
	if(maincate == "item") {
		$(".item-li").addClass("active");
	} else if(maincate == "board") {
		$(".board-li").addClass("active");
	} else if(maincate == "reply") {
		$(".reply-li").addClass("active");
	}
	
	/* header Text */
	if(cate.val() == "item") {
		$(".app-content-headerText").html("아이템");
	} else if(cate.val() == "board") {
		$(".app-content-headerText").html("게시글");
	} else if(cate.val() == "reply") {
		$(".app-content-headerText").html("댓글");
	}
	
	/* 페이지분할 5개 
	function varPage(varRecords) {
	var btr = "";
	var endPage = Math.ceil(curPage/5.0)*Math.ceil(varRecords/5.0) - Math.ceil((varRecords-25)/5.0);
	var startPage = endPage - (endPage-1);
	
	var prev = curPage > 1;
	var next = false;
	
	console.log("startPage = " + startPage);
	console.log("endPage = " + endPage);
	console.log("next = " + next);
	
	
	if(endPage * Math.ceil(varRecords/5.0) - Math.ceil((varRecords-25)/5.0) >= varRecords) {
		endPage = Math.ceil(varRecords/5.0);
	}
	
	if(endPage * 5 < varRecords) {
		next = true;
	} */
	
	
	
});

	

</script>
</html>