import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * InfectStatistic
 * TODO
 *
 * @author xxx
 * @version xxx
 * @since xxx
 */
class InfectStatistic 
{
	//接收命令行参数
	private String[] arg;
	//是否读取所有日志文件
	private boolean isRead;
	//日志最新日期
	private String date;
	//默认日志传入路径
	private String logPath;
	//默认output文件传入路径
	private String outputPath;
	//存放省份名称
	private List<String> name;
	//存放省份名称与其具体情况的映射
	private HashMap<String,Province> map;
		
	//构造函数
	public InfectStatistic(String[] args)
	{
		isRead = true;
		arg = args;
		logPath = "G:/log/";
		name = new ArrayList<>();
		map = new HashMap<String,Province>();
		this.init();
	}
		
	//处理日志文件
	public void deal() throws IOException
	{	    
						
	    List<String> files = new ArrayList<String>();
	    File file = new File(logPath);
	    File[] tempList = file.listFiles();
	    
	    //读取日志文件
	    for (int i = 0; i < tempList.length; i++) 	                
	    {     	
	                  
	        String logDate = new String(tempList[i].getName());	                  
	        String[] sArray = logDate.split("\\.");	                  
	        logDate = new String(sArray[0]);
	                      	                   
	        if (isRead || (logDate.compareTo(date)) <= 0) 	                   
	        {	                 	
	        	BufferedReader br = null;	        	
	        	String line = null;
	        	FileReader fr = new FileReader(tempList[i]);	        	
                br = new BufferedReader(fr);
                
	        	while((line = br.readLine()) != null)
	        	{
	        		String[] array = line.split(" ");
	        		dealOneLine(array);
	        		//System.out.println(line);
	        	}
	        		        	        	
	        	//files.add(tempList[i].toString());   	        	
	        	//System.out.println(logDate);	                    
	        }            	                
	    }
	}
		
	//处理单行
	private void dealOneLine(String[] array) 
	{
		//忽略注释行
		if(array[0].equals("//"))
		{
			return;
		}
		//未录入该省份则创建该省份的实例
		if(!name.contains(array[0]))
		{
			name.add(array[0]);
			map.put(array[0],new Province(array[0]));
		}
				
		switch(array[1])
		{
		    case "新增":
		    	if(array[2].equals("疑似患者"))
		    	{
		    		map.get(array[0]).addSp(array[3]);
		    	}
		    	else
		    	{
		    		map.get(array[0]).addIp(array[3]);
		    	}
		        break;
		    case "感染患者":
		        break;
		    case "疑似患者":
		        break;
		    case "死亡":
		    	map.get(array[0]).dead(array[2]);
		    	break;
		    case "治愈":
		    	map.get(array[0]).cure(array[2]);
		        break;
		    case "排除":
		    	map.get(array[0]).remove(array[3]);
		    	break;
		    default:
		    	break;
		}	

	}

	//生成output.txt文件
	public void output()
	{
		for(int i=0;i<name.size();i++)
		{
			//System.out.println(i+":"+name.get(i));
			map.get(name.get(i)).output();
		}
	}
		
	//初始化
	public void init()
	{
		for(int i=0;i<arg.length;i++)
		{			
			switch(arg[i])
			{
			    case "-date":
				    date = new String(arg[i+1]);
				    isRead = false;	
				    break;
			    case "-log":
				    logPath = new String(arg[i+1]);
				    break;
			    case "-out":
				    outputPath = new String(arg[i+1]);
				    break;
				default:	
					break;
			}			
		}
	}
				
    public static void main(String[] args) throws IOException 
    {
    	if(args[0].equalsIgnoreCase("list"))
    	{
    		InfectStatistic l = new InfectStatistic(args);
    		l.deal();	
    		l.output();
    	}
    	else
    	{
    		System.out.print("未知的命令：" + args[0]);
    	}    		
    }
}
//表示一个省份详细情况
class Province
{
	//省份名称
	private String name;
	//疑似患者
	private int suspectedPatients;
	//感染患者
	private int infectionPatients;
	//治愈
	private int cure;
	//死亡
	private int dead;
	
	public Province(String n)
	{
		name = n;
	}
	//新增疑似患者
	public void addSp(String str)
	{
		str = str.substring(0,str.length()-1);
		suspectedPatients += Integer.parseInt(str);
	}
	//新增疑似患者
	public void addIp(String str)
	{
		str = str.substring(0,str.length()-1);
		infectionPatients += Integer.parseInt(str);
	}	
	//治愈患者
	public void cure(String str)
	{
		str = str.substring(0,str.length()-1);
		cure += Integer.parseInt(str);
		infectionPatients -= Integer.parseInt(str);
	}	
	//患者死亡
	public void dead(String str)
	{
		str = str.substring(0,str.length()-1);
		dead += Integer.parseInt(str);
		infectionPatients -= Integer.parseInt(str);
	}	
	//排除疑似患者
	public void remove(String str)
	{
		str = str.substring(0,str.length()-1);
		suspectedPatients -= Integer.parseInt(str);
	}
	//输出本省情况
	public void output()
	{
		System.out.println(name + " 感染患者" + infectionPatients + "人 " +
	                              "疑似患者" + suspectedPatients + "人 " +
				                  "治愈" + cure + "人 " +
	                              "死亡" + dead + "人");
	}
}

