//显示计数器的图标
function get_imgcounter()
{
	var the_counterhtml,dif_counterlen,the_counternum;
	the_counterhtml="";
	if(ncounter_len<show_counternum)
	{
		dif_counterlen=show_counternum-ncounter_len;
		for(var i=0;i<dif_counterlen;i++)
		{
			the_counterhtml=the_counterhtml + "<img src='" + counter_imgpath + "0.gif' />"
		}
	}
	for(var i=0;i<ncounter_len;i++)
	{
		the_counternum=the_newwcounter.substring(i,i+1);
		the_counterhtml=the_counterhtml + "<img src='" + counter_imgpath + the_counternum + ".gif' />"
	}
	return the_counterhtml;
}