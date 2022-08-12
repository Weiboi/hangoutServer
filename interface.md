## login

请求方法:post

url:http://121.5.154.71:8080/hangout/login

请求参数:


| 字段 | 说明                            | 类型   | 备注      | 是否必填 |
| ---- |-------------------------------| ------ |---------|------|
| code | wx.login()         | String | 临时登录凭证  | 是    |
| encryptedData | wx.getUserProfile()| String | 已加密用户信息 | 否    |
| iv |  wx.getUserProfile()            | String |         | 否    |
返回参数：


| 字段      | 说明      | 类型   | 备注        | 是否必填 |
| --------- |---------| ------ |-----------| ----- |
| sessionId | 自定义用户标识 | string | 后续用于标识用户  | 是    |
