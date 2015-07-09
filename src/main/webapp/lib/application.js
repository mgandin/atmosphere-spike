$(function () {
    "use strict";

    $.get( document.location.toString() + "rest/refresh/3DS/start" , function( data ) {
       var uuid = data;
       var content = $('#content');
           var input = $('#input');
           var status = $('#status');
           var logged = false;
           var socket = $.atmosphere;
           var request = { url: document.location.toString() + 'async',
                           contentType : "application/json",
                           logLevel : 'debug',
                           transport : 'websocket' ,
                           trackMessageLength : true,
                           fallbackTransport: 'long-polling'};


           request.onOpen = function(response) {

           };

           request.onMessage = function (response) {
               var message = response.responseBody;
               addMessage(message, new Date());
           };

           request.onClose = function(response) {
               logged = false;
           }

           request.onError = function(response) {
               content.html($('<p>', { text: 'Sorry, but there\'s some problem with your '
                   + 'socket or the server is down' }));
           };

           var subSocket = socket.subscribe(request, function(data) {
               subSocket.push(uuid);
           });
           function addMessage(message, datetime) {
                   content.text((datetime.getHours() < 10 ? '0' + datetime.getHours() : datetime.getHours()) + ':'
                       + (datetime.getMinutes() < 10 ? '0' + datetime.getMinutes() : datetime.getMinutes())
                       + ': ' + message);
               }
    });



});