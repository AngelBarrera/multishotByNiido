var exec = require('cordova/exec');

function Multishot() {
  //console.log("plugin com.vbandrew.multishot: ha sido creado");
}

Multishot.prototype.capture = function(data, success, fail){
  exec(success, fail, "Multishot", "camera",data);
};


var p = new Multishot();
module.exports = p;