
$(function() {

	/**
	 *課題1の入力データをサーバへ送信し、結果を画面に表示
	 */
  $("#request1").click(function() {
    $.ajax({
      type: "GET",
      url: "/ServletTest0/ServletTest1",
      data: {
        requestJs: $("#input1").val()
      },
      success: function(data) {
        $("#result1").html(data.responseMessage);
      },
      error: function(XMLHttpRequest, textStatus, errorThrown) {
        alert("リクエスト時になんらかのエラーが発生しました：" + textStatus + ":\n" + errorThrown);
      }
    });
  });

	/**
	 *課題2の入力データをサーバへ送信し、結果を画面に表示
	 */
  $("#request2").click(function() {
    $.ajax({
      type: "GET",
      url: "/ServletTest0/ServletTest2",
      data: {
        requestJs: $("#input2").val()
      },
      success: function(data) {
        $("#result2").html(data.responseMessage);
      },
      error: function(XMLHttpRequest, textStatus, errorThrown) {
        alert("リクエスト時になんらかのエラーが発生しました：" + textStatus + ":\n" + errorThrown);
      }
    });
  });


	/**
	 *課題2の入力データをサーバへ送信し、結果を画面に表示
	 */
  $("#request3").click(function() {
    $.ajax({
      type: "GET",
      url: "/ServletTest0/ServletTest3",
      data: {
        requestJs: $("#input3").val()
      },
      success: function(data) {
        $("#result3").html(data.responseMessage);
      },
      error: function(XMLHttpRequest, textStatus, errorThrown) {
        alert("リクエスト時になんらかのエラーが発生しました：" + textStatus + ":\n" + errorThrown);
      }
    });
  });
});
