package cgb.spring.service;

import cgb.spring.annotation.Lazy;
import cgb.spring.annotation.Service;

@Lazy(true)
@Service("sysLogService")
public class SysLogService {
	public SysLogService() {
		System.out.println("SysLogService()");
	}
}
