<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../../includes/common.jsp" %>
    <link href="/commoncss/sidebar.css" rel="stylesheet" type="text/css" />
    <title>MyPage</title>
    <style>

        main {
            width: 100%;
            padding-left: 30px;
        }

        .divTitle {
            margin-top: 10px;
            font-size: large;
        }

        th > label {
            margin-left: 15px;
            margin-right: 15px;
        }

        .content-box {
            /*border-top: 1px solid #999;*/
            border-bottom: 1px solid #999;
            padding: 20px 60px 20px 10px;
        }
        .inquiry_info {
            font-size: 12px;
            /*padding: 20px 60px 20px 10px;*/
        }
        .text {
            width: fit-content;
            padding: 5px;
            border-radius: 1rem;
            background-color: #ededf7;
            color: black;
        }
        .gap {
            display: inline-block;
            font-size: 0;
            width: 1px;
            height: 10px;
            background-color: #d5d5d5;
            margin: 0 10px 0;
            box-sizing: border-box;
        }
        .ctg-item {
            font-size: 14px;
            line-height: 22px;
            letter-spacing: -0.01em;
            font-weight: 400;
            color: #595959;
            padding-right: 6px;
        }
        .inquiry_title {
            margin-top: 20px;
        }
        .title {
            font-weight: bold;
            font-size: 20px;
            margin-bottom: 12px;
        }
        .inquiry_content {
            position: relative;
            padding-left: 24px;
            padding-bottom: 5px;
            padding-right: 24px;
            padding-top: 10px;
            border-radius: 10px;
            background-color: #f7f7f7;
        }
        .adminanswer {
            width: fit-content;
            border-radius: 1rem;
            background-color: #ededf7;
            color: black;
            margin-top: 20px;
            margin-bottom: 5px;
            font-size: 12px;
        }
        .cdate {
            font-size: 12px;
        }
        .admin_inquiry_info {
            font-size: 13px;
            padding: 15px 60px 15px 10px;
        }
    </style>
</head>
<body>
<!-- 헤더 시작 -->
<%@include file="../../includes/header.jsp" %>
<!-- 헤더 끝 -->
<!-- 마이 페이지 시작 -->
<section class="mypage wrapper d-flex">
    <!-- 사이드바 시작-->
    <%@include file="../../includes/sidebar.jsp" %>
    <!-- 사이드바 끝-->
    <%-- ==================== 메인 시작==================--%>
    <main>
        <%-- ==================== 마이 페이지 타이틀 ==================--%>

        <%-- ==================== 주문조회 페이지 헤더 시작 ==================--%>
        <header>
        </header>
        <%-- ==================== 주문조회 페이지 헤더 끝 ==================--%>
        <div class="divTitle">문의</div>
        <hr />
            <div class="content-box">
                <div class="inquiry_info">
                    <span class="text">답변완료</span>
                    <span class="gap"></span>
                    <span class="ctg-item">배송</span>
                    <span class="gap"></span>
                    <span class="cdate">2022-05-05</span>
                </div>
                <div class="inquiry_title">
                    <div class="inquiry_content">
                    <div class="d-flex align-items-center">
                        <div class="title">
                            책 언제 들어와요?
                        </div>
                    </div>
                    <p>
                        코딩이란 무엇인가 책을 사고 싶은데 책이 계속 품절이네요ㅠㅠㅠㅠ
                        빨리 입고 시켜주세요.
                    </p>

            </div>
            <div class="fold_box_contents">
    <div class="admin_inquiry_info">
        <span class="text">답변</span>
        <span class="gap"></span>
        <span class="cdate">2022-05-05</span>
    </div>
                <div class="inquiry_content">
                    <div class="inquiry_content_area">
                        <p>고개님의 소리에 관심을 가지고 다가가겠습니다.</p>
                    </div>
                </div>
            </div>
    </main>
    <%-- ==================== 메인 끝 ==================--%>
</section>
<!-- 마이 페이지 끝 -->
<!-- 풋터 시작 -->
<%@include file="../../includes/footer.jsp" %>
<!-- 풋터 끝 -->
</body>
</html>