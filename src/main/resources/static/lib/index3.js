$(function () {
    var more = false,
        autoscroll = 0;
    var limit = 1;
    var length = $(".slid-house-1").find('.bd li').length,
        liDot = '';
    if (length) {
        for (i = 0; i < length; i++) {
            liDot += '<li></li>';
        }
        $('.slid-house-1').find('.hd ul').html(liDot);
    };

    $(".slid-house-1").slide({
        mainCell: ".bd ul",
        effect: "fold",
        autoPlay: true,
        delayTime: 500,
        interTime: 6000
    });
    // if ($.cookie(COOKIE_PRE + 'auth')) {
    //   var username = $.cookie(COOKIE_PRE + 'username');
    //   if (!username) username = $.cookie()
    // } else {

    // }
    //$('#container').html('');
    $('.search-btn').click(function (e) {
        $('.search-box').addClass('search-selected');
        e ? e.stopPropagation() : event.cancelBubble = true;
    })
    $(".search-t").click(function (e) {
        e ? e.stopPropagation() : event.cancelBubble = true;
    });
    $(document).click(function () {
        $(".search-box").removeClass('search-selected');
    })
    // 鐎戝竷娴佸姞杞�
    // $("img.lazy").lazyload({
    //   load:function(){
    //     $('#container').BlocksIt({
    //       numOfCol:5,
    //       offsetX: 8,
    //       offsetY: 8
    //     });
    //   }
    // });
    // 婊氬姩鍔犺浇鏇村
    // $(window).scroll(function(){
    //     // 褰撴粴鍔ㄥ埌鏈€搴曢儴浠ヤ笂50鍍忕礌鏃讹紝 鍔犺浇鏂板唴瀹�
    //   if ($(document).height() - $(this).scrollTop() - $(this).height()<50){
    //     $('#container').append($("#test").html());
    //     $('#container').BlocksIt({
    //       numOfCol:3,
    //       offsetX: -14,
    //       offsetY: 0
    //     });
    //     // $("img.lazy").lazyload();
    //   }
    // });

    // 婊氬姩鍔犺浇鏇村
    get_data(limit, 12);

    //  鐐瑰嚮鍔犺浇鏇村
    $('.loading_more').click(function () {
        get_more();

    })

    function scrolls() {
        $(window).scroll(function () {
            if (autoscroll < 3 && ($(document).height() - $(this).scrollTop() - $(this).height() < 290)) {
                get_more();
            }
        });
    }

    function get_more() {
        if (more) {
            return false;
        }
        more = true;
        limit = $('#container .news_li').length;
        get_data(limit, 6);
    }

    function get_data(limit, offset) {
        $('.loading_more').css('display', 'none');
        $('#infscr-loading').css('display', 'block');
        /*var url = '';
        if (offset > 0 && ('undefined' == typeof catid)) {
		
            //url = APP_URL+'?app=member&controller=langcao&action=indexmore&limit='+limit+'&offset='+offset+ '&rember=' + rember_publish;
            if ('undefined' != typeof contentid) {
                return false;
            }
			url = APP_URL+'?app=member&controller=langcao&action=indexmore&limit='+limit+'&offset='+offset+ '&rember=';
            //url = 'http://apps.fjii.com/?app=member&controller=langcao&action=indexmore&limit=' + limit + '&offset=' + offset;
        } else if ('undefined' == typeof catid) {
            url = APP_URL+'?app=member&controller=langcao&action=indexmore&limit='+limit+ '&rember=' + rember_publish;
            //url = 'http://apps.fjii.com/?app=member&controller=langcao&action=indexmore&limit=' + limit;
        } else if (offset > 0 && ('undefined' != typeof catid)) {
            url = APP_URL + '?app=member&controller=langcao&action=listmore&limit=' + limit + '&catid=' + catid;
        } else if ('undefined' != typeof catid) {
            url = APP_URL + '?app=member&controller=langcao&action=listmore&limit=' + limit + '&catid=' + catid + '&offset=6';
        }
        $("div[ids=adds]").remove();*/
        /*try {
            $.ajax({
                type: "GET",
                url: url,
                dataType: "jsonp",
                jsonp: "callback",
                timeout: 3000,
                jsonCallback: "success_jsonpCallback",
                success: function (data) {
                    more = false;
                    autoscroll++;
                    if (data.length > 0) {
                        var num = data.length;
                        var html = '';
						var txtClass = '';
                        for (var i = 0; i < num; i++) {
							txtClass = '';
                            html += '<div class="news_li animate">';
                            html += '<div class="neselis">';
                            html += '<span class="mark pc_mark">' + data[i]['cname'] + '</span>';
							if (data[i]['thumb']) {
	                            html += '<div class=" news_tu">';
	                            html += '<a href="' + data[i]['url'] + '" class="tiptitleImg" target="_blank">';
	                            html += '<img src="' + data[i]['thumb'] + '" alt="' + data[i]['title'] + '">';
	                            html += '<span class="p_time"></span>';
	                            html += '</a>';
	                            html += '</div>';
							} else {
								txtClass = 'class="mt30"'
							}
                            html += '<h2 '+txtClass+'><a href="' + data[i]['url'] + '" target="_blank">' + data[i]['title'] + '</a></h2>';
                            html += '<p>' + data[i]['content'] + '</p>';
                            html += '<div class="pdtt_trbs">';
                            html += '<a href="' + data[i]['url'] + '" target="_blank">' + (data[i]['sname'] != null? data[i]['sname'] : '') + '</a>';
                            html += '<span>' + data[i]['published'] + '</span>';
                            html += '</div>';
                            html += '</div>';
                            html += ' </div>';
                        }
                    }
                    setTimeout(function () {
                        $('#container').append(html);
                        $('#container').BlocksIt({
                            numOfCol: 3,
                            offsetX: 0,
                            offsetY: 0
                        });
                        $('.loading_more').css('display', 'block');
                        $('#infscr-loading').css('display', 'none');
                        scrolls();
                    }, 1000)


                },
                error: function () {
                    //搴斿鏈嶅姟鍣ㄩ敊璇€�
                    more = false;
                    $('.loading_more').css('display', 'block');
                    $('#infscr-loading').css('display', 'none');
                }
            });
        } catch (e) {
            more = false;
            $('.loading_more').css('display', 'block');
            $('#infscr-loading').css('display', 'none');
        }*/
    }

    // 寮圭獥
    var hader = '<div id="login-modal" class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-body modal-body-alert">';

    var userbody = '<div class="modal-alert-title">用户登录</div>' +
        '<i class="icon-spit icon-modal icon-alert-close"></i>' +
        '<div class="user-login-box">' +
        '<div class="login-form username-box login-user ">' +
        '<label class="login-label transition">' +
        '<input id="login_username" class="login-input username login-username" placeholder="请输入账号">' +
        '<span class="error-box">账号错误</span>' +
        '</label>' +
        '<label class="login-label">' +
        '<input id="login_password" class="login-input password" type="password" placeholder="请输入密码">' +
        '<span class="error-box">密码错误</span>' +
        '</label>' +
        '<div class="login-operation">' +
        '<label><input id="autologin" type="checkbox">&nbsp;自动登录</label>' +
        '<a href="#" class="js-forget-passward pull-right">忘记密码</a>' +
        '</div>' +
        '<button class="js-btn-login btn-login">登&nbsp;录</button>' +
        '</div>' +
        '<div class="js-open-register register-text js-register">极速注册</div>' +
        '</div>';
    var regisboyd = '<div class="modal-alert-title">注册</div>' +
        '<i class="icon-spit icon-modal icon-alert-close"></i>' +
        '<div class="user-login-box">' +
        '<div class="login-form username-box login-regist ">' +
        '<label class="login-label transition">' +
        '<input id="login_username" class="login-input username login-username" maxlength="20" placeholder="请输入用户名">' +
        '<span class="error-box">用户名不能为空</span>' +
        '</label>' +
        '<label class="login-label transition">' +
        '<input id="login_username" class="login-input username login-username" placeholder="请填写手机号或邮箱">' +
        '<span class="error-box">手机号或邮箱不能为空</span>' +
        '</label>' +
        '<label class="login-label">' +
        '<input id="login_password" class="login-input password" type="password" placeholder="请输入6~24位密码">' +
        '<span class="error-box">密码不能为空</span>' +
        '</label>' +
        '<button class="js-btn-regist btn-login">注&nbsp;册</button>' +
        '</div>' +
        '<div class="js-open-register register-text js-login">已有登录账号</div>' +
        '</div>';

    var footer = '</div></div></div></div><div class="modal-backdrop fade in"></div>';

    $(document).on('click', '.js-login', function () {
        if ($('div').is('#login-modal')) {
            $('.modal-body').html(userbody);
        } else {
            $('body').addClass('modal-open');
            $('body').append(hader + userbody + footer);
            $('.fade').css('display', 'block');
            setTimeout(function () {
                $('.fade').addClass('in')
            }, 20)
        }

    });
    $(document).on('click', '.js-register', function () {
        if ($('div').is('#login-modal')) {
            $('.modal-body').html(regisboyd);
        } else {
            $('body').addClass('modal-open');
            $('body').append(hader + regisboyd + footer);
            $('.fade').css('display', 'block');
            setTimeout(function () {
                $('.fade').addClass('in')
            }, 20)
        }

    })
    $(document).on('click', '.icon-alert-close', function () {
        $('.fade').removeClass('in');
        setTimeout(function () {
            $('.fade').css('display', 'none');
        }, 100)
        $('.fade').remove();
        $('body').removeClass('modal-open');
    })
    $(document).on('mouseenter mouseout', '.icon-alert-close', function () {
        if (event.type == 'mouseover') {
            $(this).addClass("hover");
        } else {
            $(this).removeClass("hover");
        }
    })
    $(".header-menu li.nav-news").hover(function () {
        $(this).addClass("hover");
    }, function () {
        $(this).removeClass("hover");
    });
    var winHeight = $(document).scrollTop();
    $(window).scroll(function () {
        var scrollY = $(document).scrollTop(); // 鑾峰彇鍨傜洿婊氬姩鐨勮窛绂伙紝鍗虫粴鍔ㄤ簡澶氬皯
        if (scrollY > 70) { //濡傛灉婊氬姩璺濈澶т簬550px鍒欐樉绀猴紝鍚﹀垯鍒犻櫎鏄剧ず绫�
            $(".header").addClass('showed');
            $('.article-left-grou_share').addClass('artleft');
        } else {
            $(".header").removeClass('showed');
            $('.article-left-grou_share').removeClass('artleft');
        }
        if (scrollY > 100) {
            $('.widget-tool').css('display', 'block');
        } else {
            $('.widget-tool').css('display', 'none');
        }

    });
    //褰撶偣鍑昏烦杞摼鎺ュ悗锛屽洖鍒伴〉闈㈤《閮ㄤ綅缃�
    $(".back-up").click(function () {
        $('body,html').animate({
            scrollTop: 0
        }, 500);
        return false;
    });
});