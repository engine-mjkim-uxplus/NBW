<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>상품 분류 페이지</title>
    <%@include file="../../includes/common.jsp" %>
    <style>
        main{
            width:70%;
            margin:auto;
            padding-top: 10px;
        }

        ul {
            list-style: none;
        }

        .col-4 {
            background-color: rgb(244, 255, 253);
            padding-top: 5px;
            margin-right: 2px;
            text-align: center;
            height: 40px;
            border-radius: 5px;
            list-style: none;
        }

        .container {
            margin-bottom: 100px;
        }

        .col-3 {
            margin-bottom: 40px;
        }

        .col-3>a {
            text-decoration: none;
            text-align: center;
        }

        .col-4>a {
            color: rgb(21, 30, 61);
            font-size: smaller;
            text-decoration: none;
        }

        a {
            text-decoration: none;
        }

        #p-img {
            border-radius: 10px;
        }

        #p-title {
            padding-top: 5px;
            width: 200px;
            font-size: larger;
            color: black;
            font-weight: bolder;
        }

        #p-price {
            color: rgb(255, 179, 0);
            font-size: larger;
            font-weight: bolder;
        }

    </style>
</head>

<body>
    <!-- 헤더 시작 -->
    <%@include file="/WEB-INF/includes/header.jsp" %>
    <!-- 헤더 끝 -->

    <!-- MAIN ==> 상품 분류 테스트 양식 시작! -->
    <main>
        <!-- ---------------------------------------- 상품 분류 & 검색조건 NAV 시작! ------------------------------------ -->
            <!-- *상품분류* NAV START 입니다. -->
            <nav>
                <div class="row justify-content-md-center">
                    <div class="col"
                        style="text-align: center;
                        padding-top:5px;
                        color: rgb(21, 30, 61);
                        font-size: larger;
                        background-color: rgb(242, 242, 242);
                        height: 40px;
                        border-radius: 5px;">
                        <label style="font-size: medium"> 카테고리 </label>
                    </div>
                    <div class="col-4 col-lg-1"><a href="#">전체</a></div>
                    <div class="col-4 col-lg-1"><a href="#">철학</a></div>
                    <div class="col-4 col-lg-1"><a href="#">종교</a></div>
                    <div class="col-4 col-lg-1"><a href="#">사회과학</a></div>
                    <div class="col-4 col-lg-1"><a href="#">자연과학</a></div>
                    <div class="col-4 col-lg-1"><a href="#">기술과학</a></div>
                    <div class="col-4 col-lg-1"><a href="#">예술</a></div>
                    <div class="col-4 col-lg-1"><a href="#">언어</a></div>
                    <div class="col-4 col-lg-1"><a href="#">문학</a></div>
                    <div class="col-4 col-lg-1"><a href="#">역사</a></div>
                </div>
            </nav>
            <!-- *상품분류* NAV END. -->
            <br>
            <!-- *검색조건* NAV START 입니다. -->
            <nav>
                <div class="row justify-content-md-center">
                    <div class="col"
                        style="text-align: center;
                        padding-top:5px;
                        color: rgb(21, 30, 61);
                        font-size: larger;
                        background-color: rgb(242, 242, 242);
                        height: 40px;
                        border-radius: 5px;">
                        <label style="font-size: medium"> 검색/조건 </label>
                    </div>
                    <div class="col-4 col-lg-1"><a href="#">할인률</a></div>
                    <div class="col-4 col-lg-2"><a href="#">높은가격</a></div>
                    <div class="col-4 col-lg-2"><a href="#">낮은가격</a></div>
                    <div class="col-4 col-lg-1"><a href="#">평점순</a></div>
                    <div class="col-4 col-lg-2"><a href="#">발행일순</a></div>
                    <div class="col-4 col-lg-1"><a href="#">리뷰순</a></div>
                    <div class="col-4 col-lg-1"><a href="#">판매량</a></div>
                </div>
            </nav>
            <!-- *검색조건* NAV END. -->

        <!-- ---------------------------------------- 상품 분류 & 검색조건 NAV 끝! ------------------------------------ -->
        <br>
        <hr>

        <!-- ---------------------------------------- 상품 미리보기 시작! ---------------------------------------- -->
        <div class="container">
        <br>
        <!-- 한 ROW 에 상품 4개(COL=4)를 보여줄 예정입니다. -->
                <div class="row justify-content-md-center" >

                <c:forEach items = "#{list}" var="list">
                    <div class="col-3">
                        <!-- <li> -->
                            <a href="#">
                                <!-- 상품 썸네일 DIV 입니다. -->
                                <div class="p-thumb" style="text-align: center;">
                                    <!-- DB에서 불러올 *상품이미지(p_img)* 입니다. -->
                                        <img class="p-img" width="190px" alt="" src="${list.getP_img()}"/>
                                </div>
                                <!-- 상품 썸네일 DIV END -->

                                <!-- DB에서 불러올 *상품제목(p_title)* 입니다. -->
                                <div class="col-md-4 offset-md-2" class="p-title" style="text-align: center;">
                                        <p style="font-size: larger; background-color: rgb(250, 243, 226);">${list.getP_title()}</p>
                                </div>
                            </a>
                            <div class="row justify-content-md-center">
                                <!-- DB에서 불러올 *상품저자(p_author)* 입니다. -->
                                <div class="p-author" class="col-6 col-sm-4">
                                    <p style="text-align: center; font-weight: bold;">${list.getP_author()}</p>
                                </div>
                                <!-- DB에서 불러올 *상품출판사(p_publisher)* 입니다. -->
                                <div class="p-publisher" class="col-6 col-sm-3">
                                    <p style="text-align: center; font-weight: bold;">${list.getP_publisher()}</p>
                                </div>
                                <!-- DB에서 불러올 *상품가격(p_publisher)* 입니다. -->
                                <div class="p-price" style="text-align:center;">
                                    <p style="font-size: medium;">${list.getP_price()}</p>
                                </div>
                            </div>
                    </div>
                </c:forEach>
                    </div>
            <!-- 1행 1열 끝 -->

            </div>
        <!-- 첫번째 줄 끝 -->
        <br>
        <hr>
        <!-- ---------------------------------------- 상품 미리보기 끝! ---------------------------------------- -->

        <!-- ---------------------------------------- 페이지네이션 시작! ----------------------------------------
        -------------------------------- * 한 페이지 당 10개의 상품을 불러올 예정입니다. -------------------------------->
        <%--  서버로부터 전송받은 pagination 속성에 저장된 startPage, endPage 값을 가지고 forEach 태그를 이용해서 페이지 번호를 화면에 출력한다.   --%>
      <div>
          ${pagination}
      </div>
    </main>

</body>
</html>
