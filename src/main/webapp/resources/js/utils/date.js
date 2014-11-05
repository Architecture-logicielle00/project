/**
 * Created by David on 2014-10-30.
 */


Date.prototype.yyyymmdd = function() {
    var yyyy = this.getFullYear().toString();
    var mm = (this.getMonth()+1).toString();
    var dd  = this.getDate().toString();
    return yyyy + "-" + (mm[1]?mm:"0"+mm[0]) + "-" +(dd[1]?dd:"0"+dd[0]);
};

Date.prototype.hhmmss = function() {
    var hh = this.getHours().toString();
    var mm = (this.getMinutes()).toString();
    var ss  = this.getSeconds().toString();
    return hh + ":" + (mm[1]?mm:"0"+mm[0]) + ":" +(ss[1]?ss:"0"+ss[0]);
};