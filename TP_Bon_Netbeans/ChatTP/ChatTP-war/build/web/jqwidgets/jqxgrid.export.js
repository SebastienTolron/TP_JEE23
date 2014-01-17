/*
jQWidgets v3.1.0 (2013-Dec-23)
Copyright (c) 2011-2014 jQWidgets.
License: http://jqwidgets.com/license/
*/

(function(a){a.extend(a.jqx._jqxGrid.prototype,{exportdata:function(q,y,x,o,r,t,f){if(!a.jqx.dataAdapter.ArrayExporter){throw"jqxGrid: Missing reference to jqxdata.export.js!"}if(x==undefined){x=true}var G=this;if(o==undefined){var o=this.getrows();if(o.length==0){throw"No data to export."}}this.exporting=true;this.loadondemand=true;if(this.altrows){this._renderrows(this.virtualsizeinfo)}var E=r!=undefined?r:false;var D={};var n={};var v=[];var l=this.host.find(".jqx-grid-cell:first");var w=this.host.find(".jqx-grid-cell-alt:first");l.removeClass(this.toThemeProperty("jqx-grid-cell-selected"));l.removeClass(this.toThemeProperty("jqx-fill-state-pressed"));w.removeClass(this.toThemeProperty("jqx-grid-cell-selected"));w.removeClass(this.toThemeProperty("jqx-fill-state-pressed"));l.removeClass(this.toThemeProperty("jqx-grid-cell-hover"));l.removeClass(this.toThemeProperty("jqx-fill-state-hover"));w.removeClass(this.toThemeProperty("jqx-grid-cell-hover"));w.removeClass(this.toThemeProperty("jqx-fill-state-hover"));var g="cell";var e=1;var F="column";var c=1;var h=[];for(var A=0;A<this.columns.records.length;A++){var d=this.columns.records[A];if(d.cellclassname!=""){d.customCellStyles=new Array();if(typeof d.cellclassname=="string"){d.customCellStyles.push(d.cellclassname)}else{for(var B=0;B<o.length;B++){var u=this.getrowboundindex(B);var b=d.cellclassname(u,d.displayfield,o[B][d.displayfield],o[B]);if(b){d.customCellStyles[B]=b}}}}}a.each(this.columns.records,function(J){var M=a(G.table[0].rows[0].cells[J]);if(G.table[0].rows.length>1){var j=a(G.table[0].rows[1].cells[J])}var I=this;var K=function(O){O.removeClass(G.toThemeProperty("jqx-grid-cell-selected"));O.removeClass(G.toThemeProperty("jqx-fill-state-pressed"));O.removeClass(G.toThemeProperty("jqx-grid-cell-hover"));O.removeClass(G.toThemeProperty("jqx-fill-state-hover"));if(I.customCellStyles){for(var P in I.customCellStyles){O.removeClass(I.customCellStyles[P])}}};K(M);if(j){K(j)}if(this.displayfield==null){return true}if(G.showaggregates){if(G.getcolumnaggregateddata){h.push(G.getcolumnaggregateddata(this.displayfield,this.aggregates,true,o))}}var L=G._getexportcolumntype(this);if(this.exportable&&(!this.hidden||E)){D[this.displayfield]={};D[this.displayfield].text=this.text;D[this.displayfield].width=parseInt(this.width);if(isNaN(D[this.displayfield].width)){D[this.displayfield].width=60}D[this.displayfield].formatString=this.cellsformat;D[this.displayfield].localization=G.gridlocalization;D[this.displayfield].type=L;D[this.displayfield].cellsAlign=this.cellsalign;D[this.displayfield].hidden=!x}g="cell"+e;var N=a(this.element);if(this.element==undefined){N=a(this.uielement)}F="column"+c;if(q=="html"||q=="xls"||q=="pdf"){var i=function(O,W,V,P,U,R,Q,S,T){n[O]={};n[O]["font-size"]=W.css("font-size");n[O]["font-weight"]=W.css("font-weight");n[O]["font-style"]=W.css("font-style");n[O]["background-color"]=R._getexportcolor(W.css("background-color"));n[O]["color"]=R._getexportcolor(W.css("color"));n[O]["border-color"]=R._getexportcolor(W.css("border-top-color"));if(V){n[O]["text-align"]=U.align}else{n[O]["text-align"]=U.cellsalign;n[O]["formatString"]=U.cellsformat;n[O]["dataType"]=L}if(q=="html"||q=="pdf"){n[O]["border-top-width"]=W.css("border-top-width");n[O]["border-left-width"]=W.css("border-left-width");n[O]["border-right-width"]=W.css("border-right-width");n[O]["border-bottom-width"]=W.css("border-bottom-width");n[O]["border-top-style"]=W.css("border-top-style");n[O]["border-left-style"]=W.css("border-left-style");n[O]["border-right-style"]=W.css("border-right-style");n[O]["border-bottom-style"]=W.css("border-bottom-style");if(V){if(Q==0){n[O]["border-left-width"]=W.css("border-right-width")}n[O]["border-top-width"]=W.css("border-right-width");n[O]["border-bottom-width"]=W.css("border-bottom-width")}else{if(Q==0){n[O]["border-left-width"]=W.css("border-right-width")}}n[O]["height"]=W.css("height")}if(U.exportable&&(!U.hidden||E)){if(S==true){if(!D[U.displayfield].customCellStyles){D[U.displayfield].customCellStyles=new Array()}D[U.displayfield].customCellStyles[T]=O}else{if(V){D[U.displayfield].style=O}else{if(!P){D[U.displayfield].cellStyle=O}else{D[U.displayfield].cellAltStyle=O}}}}};i(F,N,true,false,this,G,J);c++;i(g,M,false,false,this,G,J);if(G.altrows){g="cellalt"+e;i(g,j,false,true,this,G,J)}if(this.customCellStyles){for(var H in I.customCellStyles){M.removeClass(I.customCellStyles[H])}for(var H in I.customCellStyles){M.addClass(I.customCellStyles[H]);i(g+I.customCellStyles[H],M,false,false,this,G,J,true,H);M.removeClass(I.customCellStyles[H])}}e++}});if(this.showaggregates){var C=[];var z=q=="xls"?"AG":"";var k=this.groupable?this.groups.length:0;if(this.rowdetails){k++}if(h.length>0){a.each(this.columns.records,function(j){if(this.aggregates){for(var I=0;I<this.aggregates.length;I++){if(!C[I]){C[I]={}}if(C[I]){var J=G._getaggregatename(this.aggregates[I]);var K=G._getaggregatetype(this.aggregates[I]);var H=h[j-k];if(H){C[I][this.displayfield]=z+J+": "+H[K]}}}}});a.each(this.columns.records,function(j){for(var H=0;H<C.length;H++){if(C[H][this.displayfield]==undefined){C[H][this.displayfield]=z}}})}a.each(C,function(){o.push(this)})}var m=this;var s=a.jqx.dataAdapter.ArrayExporter(o,D,n);if(y==undefined){this._renderrows(this.virtualsizeinfo);var p=s.exportTo(q);if(this.showaggregates){a.each(C,function(){o.pop(this)})}setTimeout(function(){m.exporting=false},50);return p}else{s.exportToFile(q,y,t,f)}if(this.showaggregates){a.each(C,function(){o.pop(this)})}this._renderrows(this.virtualsizeinfo);setTimeout(function(){m.exporting=false},50)},_getexportcolor:function(l){var f=l;if(l=="transparent"){f="#FFFFFF"}if(!f||!f.toString()){f="#FFFFFF"}if(f.toString().indexOf("rgb")!=-1){var i=f.split(",");if(f.toString().indexOf("rgba")!=-1){var d=parseInt(i[0].substring(5));var h=parseInt(i[1]);var j=parseInt(i[2]);var k=parseInt(i[3].substring(1,4));var m={r:d,g:h,b:j};var e=this._rgbToHex(m);if(d==0&&h==0&&j==0&&k==0){return"#ffffff"}return"#"+e}var d=parseInt(i[0].substring(4));var h=parseInt(i[1]);var j=parseInt(i[2].substring(1,4));var m={r:d,g:h,b:j};var e=this._rgbToHex(m);return"#"+e}else{if(f.toString().indexOf("#")!=-1){if(f.toString().length==4){var c=f.toString().substring(1,4);f+=c}}}return f},_rgbToHex:function(b){return this._intToHex(b.r)+this._intToHex(b.g)+this._intToHex(b.b)},_intToHex:function(c){var b=(parseInt(c).toString(16));if(b.length==1){b=("0"+b)}return b.toUpperCase()},_getexportcolumntype:function(f){var g=this;var e="string";var d=g.source.datafields||((g.source._source)?g.source._source.datafields:null);if(d){var i="";a.each(d,function(){if(this.name==f.displayfield){if(this.type){i=this.type}return false}});if(i){return i}}if(f!=null){if(this.dataview.cachedrecords==undefined){return e}var b=null;if(!this.virtualmode){if(this.dataview.cachedrecords.length==0){return e}b=this.dataview.cachedrecords[0][f.displayfield];if(b!=null&&b.toString()==""){return"string"}}else{a.each(this.dataview.cachedrecords,function(){b=this[f.displayfield];return false})}if(b!=null){if(f.cellsformat.indexOf("c")!=-1){return"number"}if(f.cellsformat.indexOf("n")!=-1){return"number"}if(f.cellsformat.indexOf("p")!=-1){return"number"}if(f.cellsformat.indexOf("d")!=-1){return"date"}if(f.cellsformat.indexOf("y")!=-1){return"date"}if(f.cellsformat.indexOf("M")!=-1){return"date"}if(f.cellsformat.indexOf("m")!=-1){return"date"}if(f.cellsformat.indexOf("t")!=-1){return"date"}if(typeof b=="boolean"){e="boolean"}else{if(a.jqx.dataFormat.isNumber(b)){e="number"}else{var h=new Date(b);if(h.toString()=="NaN"||h.toString()=="Invalid Date"){if(a.jqx.dataFormat){h=a.jqx.dataFormat.tryparsedate(b);if(h!=null){if(h&&h.getFullYear()){if(h.getFullYear()==1970&&h.getMonth()==0&&h.getDate()==1){var c=new Number(b);if(!isNaN(c)){return"number"}return"string"}}return"date"}else{e="string"}}else{e="string"}}else{e="date"}}}}}return e}})})(jQuery);