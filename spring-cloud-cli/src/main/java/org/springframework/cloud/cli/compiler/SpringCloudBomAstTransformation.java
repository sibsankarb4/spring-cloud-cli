/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.cli.compiler;

import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.transform.GroovyASTTransformation;
import org.springframework.boot.cli.compiler.DependencyManagementBomTransformation;
import org.springframework.boot.cli.compiler.GenericBomAstTransformation;

/**
 * @author Dave Syer
 *
 */
@GroovyASTTransformation(phase = CompilePhase.CONVERSION)
public class SpringCloudBomAstTransformation extends GenericBomAstTransformation {

	private static final String SPRING_CLOUD_VERSION = "Greenwich.BUILD-SNAPSHOT";

	@Override
	protected String getBomModule() {
		return "org.springframework.cloud:spring-cloud-starter-parent:" + SPRING_CLOUD_VERSION;
	}

	@Override
	public int getOrder() {
		return DependencyManagementBomTransformation.ORDER - 50;
	}

}
