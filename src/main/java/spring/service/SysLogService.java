package spring.service;

import spring.annotation.Lazy;
import spring.annotation.Service;

@Lazy(true)
@Service("sysLogService")
public class SysLogService {
	public SysLogService() {
		System.out.println("SysLogService()");
	}
}
