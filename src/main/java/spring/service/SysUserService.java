package spring.service;

import spring.annotation.Lazy;
import spring.annotation.Service;

@Lazy(false)
@Service("sysUserService")
public class SysUserService {

	public SysUserService() {
		System.out.println("SysUserService()");
	}
}
