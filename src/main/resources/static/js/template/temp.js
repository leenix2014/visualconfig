		<script type="text/x-template" id="gameinfo">
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
								<legend style="font-size: 14px;">主游戏状态信息</legend>
							</fieldset>
							<table class="layui-table" lay-skin="line">
								<colgroup>
									<col width="150">
									<col width="150">
									<col width="200">
									<col>
								</colgroup>

								<tbody>
									<tr>
										<td><b>服务器名称</b></td>
										<td>{{serverName | cityKv}}</td>
									</tr>
									<tr>
										<td><b>productId</b></td>
										<td>{{sconfig.productId}}</td>
									</tr>
									<tr>
										<td><b>服务器IP</b></td>
										<td>120.78.199.18</td>
									</tr>
									<tr>
										<td><b>运行状态</b></td>
										<td><span style="color: green;">正常</span>
											<!--<span style="color: red;" >异常</span> <span style="color: black;" >关闭</span>--></td>
									</tr>
									<tr>
										<td><b>所属目录</b></td>
										<td>/data/game/an_hui_55/dfz_xin_huai_bei_ma_jiang/current/game_server/Deploydir/dsqp</td>
									</tr>
									<tr>
										<td><b>所属版本</b></td>
										<td>2.6.7.0</td>
									</tr>
								</tbody>
							</table>
							<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
								<legend style="font-size: 14px;">主游戏配置信息</legend>
								<!--<my-text v-bind:isconfigshow="isconfigshow" ></my-text>-->
							</fieldset>
							
							<!--<div style="width: 216px; margin: 0;"> -->
							<!-- layui 2.2.5 新增 -->
							<button class="layui-btn layui-btn-fluid" v-on:click="Sysinfo" >加载详细配置</button>
							<pre id="result" v-show="isconfigshow" >
							</pre>
</script>

<script type="text/x-template" id="gameinfo-param" v-if="sconfig.productId!=''"  >
							<table class="layui-table" lay-skin="line">
								<colgroup>
									<col width="150">
									<col width="150">
									<col width="200">
									<col>
								</colgroup>

								<tbody>
									<tr>
										<td><b>gamePort(游戏端口)</b></td>
										<td>{{sconfig.gamePort}}</td>
									</tr>
									<tr>
										<td><b>resPort(资源端口)</b></td>
										<td>{{sconfig.resPort}}</td>
									</tr>
									<tr>
										<td><b>webPort(web端口)</b></td>
										<td>{{sconfig.webPort}}</td>
									</tr>
									<tr>
										<td><b>APPID</b></td>
										<td>{{sconfig.appid}}</td>
									</tr>
									<tr>
										<td><b>活动服务器地址</b></td>
										<td>{{sconfig.activityURL}}</td>
									</tr>
									<tr>
										<td><b>支付服务器地址</b></td>
										<td>{{sconfig.shoppingCenterURL}}</td>
									</tr>
									<tr>
										<td><b>是否开启分布式</b></td>
										<td>{{sconfig.simpleProxy}}</td>
									</tr>
									<tr>
										<td><b>集群是否开启</b></td>
										<td>{{sconfig.singlon}}</td>
									</tr>
									<tr>
										<td><b>玩家前缀</b></td>
										<td>{{sconfig.userIdPrefix}}</td>
									</tr>
									<tr>
										<td><b>公共库数据库名称</b></td>
										<td>{{sconfig.dbConfigMap.dictDataBaseConfig.dbNames.dictDbName}}</td>
									</tr>
									<tr>
										<td><b>游戏主库</b></td>
										<td>{{sconfig.dbConfigMap.dataBaseConfig.dbNames.dbName}}</td>
									</tr>
									<tr>
										<td><b>游戏地日志库</b></td>
										<td>{{sconfig.dbConfigMap.logDataBaseConfig.dbNames.logDbName}}</td>
									</tr>
									<tr>
										<td><b>资源服地址</b></td>
										<td>{{sconfig.resConfig.recordURL}}</td>
									</tr>
									<tr>
										<td><b>洗牌次数</b></td>
										<td>{{sconfig.cardControlConfig.n}}</td>
									</tr>
								</tbody>
							</table>
							</script>