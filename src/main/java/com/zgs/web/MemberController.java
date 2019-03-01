package com.zgs.web;

import java.util.Date;
import java.util.Map;

import com.zgs.core.BaseController;
import com.zgs.core.PageRequest;
import com.zgs.core.Result;
import com.zgs.domain.Member;
import com.zgs.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

/**
 * @author zgs
 * @since 2019/03/01
 */
@RestController
@RequestMapping("/member")
public class MemberController extends BaseController{

	@Autowired
	private IMemberService memberService;

	@GetMapping("/get/{id}")
	public Member get(@PathVariable Long id) {
		return memberService.selectById(id);
	}

	@PostMapping("/save")
	public Result save(@RequestBody Member member) {
		if (member.date == null) {
			member.date = new Date();
		}

		if (member.id != null) {
			memberService.update(member);
		} else {
			memberService.insert(member);
		}

		return Result.success(member.id);
	}

	@PostMapping("/list")
	public Map<String, Object> list(PageRequest request,
									@RequestBody Member member) {

		Condition condition = new Condition(Member.class);
		if (member.name != null) {
			condition.createCriteria().andLike("name", "%" + member.getName() + "%");
		}

		return super.selectByPageNumSize(request, () -> memberService.selectByCondition(condition));
	}

	@GetMapping("/delete/{id}")
	public Result delete(@PathVariable Long id) {
		memberService.deleteById(id);
		return Result.success(id);
	}
}
