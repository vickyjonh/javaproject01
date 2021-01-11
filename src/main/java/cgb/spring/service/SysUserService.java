package cgb.spring.service;

import cgb.spring.annotation.Lazy;
import cgb.spring.annotation.Service;

@Lazy(false)
@Service("sysUserService")
public class SysUserService {

	public SysUserService() {
		System.out.println("SysUserService()");
	}
}
