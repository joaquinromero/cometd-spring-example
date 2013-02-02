/*
 * Copyright (c) 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.chimpler.example;

import javax.inject.Singleton;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * View Controller
 * @author Frederic Dang Ngoc
 */
@Controller
@Singleton
public class ViewController {
	private TwitterService twitterService;
	
	public ViewController() {
		System.out.println("INSTANTIATE VIEWCONTROLLER");
	}
	
	@RequestMapping(value="/index")
	public String index() {
		return "index";
	}

	@RequestMapping(value="/startTwitterService", produces="application/text")
	@ResponseBody
	public String startTwitterService(@RequestParam(value="username") String username,
			@RequestParam(value="password") String password) {
		twitterService.startSample(username, password);
		return "OK";
	}

	@RequestMapping(value="/stopTwitterService", produces="application/text")
	@ResponseBody
	public String stopTwitterService() {
		twitterService.stopSample();
		return "OK";
	}

	public void setTwitterService(TwitterService twitterService) {
		this.twitterService = twitterService;
	}
	
}
