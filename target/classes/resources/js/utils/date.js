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


function incr_date(date_str){
	  var parts = date_str.split("-");
	  var dt = new Date(
	    parseInt(parts[0], 10),      // year
	    parseInt(parts[1], 10) - 1,  // month (starts with 0)
	    parseInt(parts[2], 10)       // date
	  );
	  dt.setDate(dt.getDate() + 1);
	  parts[0] = "" + dt.getFullYear();
	  parts[1] = "" + (dt.getMonth() + 1);
	  if (parts[1].length < 2) {
	    parts[1] = "0" + parts[1];
	  }
	  parts[2] = "" + dt.getDate();
	  if (parts[2].length < 2) {
	    parts[2] = "0" + parts[2];
	  }
	  return parts.join("-");
	}