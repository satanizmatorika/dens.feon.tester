package ru.dens.feon.tester.sometests;

public class TestStringConcatenationVsStringBuilderMemoryUse {

	public static void main(String[] args) throws InterruptedException {
		testStringConcatenationMemoryUse();

//		testStringBuilderMemoryUse();
	}

	private static void testStringBuilderMemoryUse() throws InterruptedException {
		String string = new StringBuilder().append("SELECT cid_performer_top_dep,\n").append(" cs_performer_top_dep,\n").append(" cid_performer_dep,\n").append(" cs_performer_dep,\n").append(" cid_performer,\n").append(" cs_performer,\n").append(" cid_topic,\n").append(" cs_topic,\n").append(" com_count,\n").append(" TO_CHAR((com_executed_not_due  + com_executed_due_less + com_executed_due_more) / com_count * 100, '990.99')       AS percent_executed,\n").append(" TO_CHAR(com_execute_count      / com_count * 100, '990.99')                                                        AS percent_execute,\n").append(" TO_CHAR(CASE WHEN (com_executed_not_due  + com_executed_due_less + com_executed_due_more) > 0 THEN com_reject / (com_executed_not_due  + com_executed_due_less + com_executed_due_more) * 100 ELSE 0 END, '990.99') AS percent_reject,\n").append(" TO_CHAR((com_executed_due_less + com_executed_due_more + com_due_less + com_due_more) / com_count * 100, '990.99') AS percent_due,\n").append(" com_executed_not_due,\n").append(" com_executed_due_less,\n").append(" com_executed_due_more,\n").append(" com_execute_count,\n").append(" com_execute_extend,\n").append(" com_due_less,\n").append(" com_due_more,\n").append(" TO_CHAR(com_accept_time, '99999999990')  AS com_accept_time,\n").append(" TO_CHAR(com_execute_time, '99999999990') AS com_execute_time,\n").append(" TO_CHAR(com_finish_time, '99999999990')  AS com_finish_time,\n").append(" com_operations_count,\n").append(" TO_CHAR(NVL(com_operations_mark, 0), '0.99')  AS com_operations_mark,\n").append(" TO_CHAR(CASE WHEN (com_executed_not_due  + com_executed_due_less + com_executed_due_more) > 0 THEN cnt_corrections / (com_executed_not_due  + com_executed_due_less + com_executed_due_more) * 100 ELSE 0 END, '990.99') AS percent_corr,\n").append(" TO_CHAR(com_reject / com_count * 100, '990.99') AS percent_missed_by_receiving,\n").append(" com_execute_operations_count,\n").append(" cnt_corrections as com_corr_count,\n").append(" com_reject com_reject_count,\n").append(" com_missed,\n").append(" TO_CHAR(CASE WHEN /*(com_executed_not_due + com_executed_due_less + com_executed_due_more)*/com_count > 0 THEN\n").append(" /*(com_executed_due_less + com_executed_due_more) / (com_executed_not_due + com_executed_due_less + com_executed_due_more)*/cnt_missed_by_receiving/com_count*100 ELSE 0 END, '990.99') prc_missed,\n").append("/*(                    + \"  (com_executed_not_due  + com_executed_due_less + com_executed_due_more) as com_executed, */\n").append(" lvl\n").append(" FROM\n").append(" (SELECT cid_performer_top_dep,\n").append("   cs_performer_top_dep,\n").append("   cid_performer_dep,\n").append("   cs_performer_dep,\n").append("   cid_performer,\n").append("   cs_performer,\n").append("   cid_topic,\n").append("   cs_topic,\n").append("   SUM(com_executed_not_due)  AS com_executed_not_due,\n").append("   SUM(com_executed_due_less) AS com_executed_due_less,\n").append("   SUM(com_executed_due_more) AS com_executed_due_more,\n").append("   SUM(com_execute_count)     AS com_execute_count,\n").append("   SUM(com_execute_extend)    AS com_execute_extend,\n").append("   SUM(com_due_less)          AS com_due_less,\n").append("   SUM(com_due_more)          AS com_due_more,\n").append("   SUM(com_reject)            AS com_reject,\n").append("   AVG(com_accept_time)       AS com_accept_time,\n").append("   AVG(com_execute_time)      AS com_execute_time,\n").append("   AVG(com_finish_time)       AS com_finish_time,\n").append("   COUNT(cid_commission)      AS com_count,\n").append("   SUM(com_operations_count)  AS com_operations_count,\n").append("   AVG(com_operations_mark)   AS com_operations_mark,\n").append("   SUM(cnt_corrections)       AS cnt_corrections,\n").append("   SUM(cnt_all)               AS cnt_all,\n").append("   SUM(cnt_missed_by_receiving) AS cnt_missed_by_receiving,\n").append("   SUM(com_execute_operations_count) AS com_execute_operations_count,\n").append("   SUM(com_missed) as com_missed,\n").append("   lvl\n").append(" FROM\n").append("   (SELECT cid_performer_top_dep ,\n").append("     cs_performer_top_dep ,\n").append("     cid_performer_dep ,\n").append("     cs_performer_dep ,\n").append("     cid_performer ,\n").append("     cs_performer ,\n").append("     cid_topic ,\n").append("     cs_topic ,\n").append("     com_executed_not_due ,\n").append("     com_executed_due_less ,\n").append("     com_executed_due_more ,\n").append("     com_execute_count ,\n").append("     com_execute_extend ,\n").append("     com_due_less ,\n").append("     com_due_more ,\n").append("     com_reject ,\n").append("     com_accept_time ,\n").append("     com_execute_time ,\n").append("     com_finish_time ,\n").append("     cid_commission ,\n").append("     com_operations_count ,\n").append("     CASE WHEN com_operations_mark = 0 THEN To_Number(NULL) ELSE com_operations_mark END com_operations_mark,\n").append("     lvl,\n").append("     To_Number(CASE WHEN cnt_corrections IS NOT NULL AND InStr(cnt_corrections, '|') > 0 THEN\n").append("                SubStr(cnt_corrections, 1, InStr(cnt_corrections, '|')-1)\n").append("     END) cnt_corrections,\n").append("     To_Number(CASE WHEN cnt_corrections IS NOT NULL AND InStr(cnt_corrections, '|') > 0 THEN\n").append("              SubStr(cnt_corrections, InStr(cnt_corrections, '|')+1)\n").append("     END) cnt_all,\n").append("     cnt_missed_by_receiving,\n").append("     com_execute_operations_count,\n").append("     com_missed\n").append("   FROM\n").append("     (SELECT\n").append("       CASE\n").append("         WHEN group_lvl.lvl = 0\n").append("         OR group_lvl.lvl   = 1\n").append("         OR group_lvl.lvl   = 2\n").append("         THEN rd.cid_performer_top_dep\n").append("         ELSE 'top_department'\n").append("       END AS cid_performer_top_dep,\n").append("       CASE\n").append("         WHEN group_lvl.lvl = 0\n").append("         OR group_lvl.lvl   = 1\n").append("         OR group_lvl.lvl   = 2\n").append("         THEN org.cs_department_description\n").append("         ELSE 'top_department'\n").append("       END AS cs_performer_top_dep,\n").append("       CASE\n").append("         WHEN group_lvl.lvl   = 1\n").append("         THEN rd.cid_performer_dep\n").append("         ELSE 'department'\n").append("       END AS cid_performer_dep,\n").append("       CASE\n").append("         WHEN group_lvl.lvl   = 1\n").append("         THEN dep.cs_department_description\n").append("         ELSE 'department'\n").append("       END AS cs_performer_dep,\n").append("       CASE\n").append("         WHEN group_lvl.lvl = 0\n").append("         THEN rd.cid_performer_emp\n").append("         ELSE 'performer'\n").append("       END AS cid_performer,\n").append("       CASE\n").append("         WHEN group_lvl.lvl = 0\n").append("         THEN pos.cs_user_description\n").append("         ELSE 'performer'\n").append("       END AS cs_performer,\n").append("       CASE\n").append("         WHEN group_lvl.lvl = 3\n").append("         THEN rd.cid_topic\n").append("         ELSE 'topic'\n").append("       END AS cid_topic,\n").append("       CASE\n").append("         WHEN group_lvl.lvl = 3\n").append("         THEN topic.cs_topic_description\n").append("         ELSE 'topic'\n").append("       END AS cs_topic,\n").append("       CASE\n").append("         WHEN rd.cd_confirmated IS NOT NULL\n").append("         /*AND rd.cn_due_time = 0*/\n").append("         AND NVL(TRE_.Is_Missed, 0) = 0\n").append("         THEN 1\n").append("         ELSE 0\n").append("       END AS com_executed_not_due,\n").append("       CASE\n").append("         WHEN rd.cd_confirmated                 IS NOT NULL\n").append("         AND /*rd.cn_due_time > 0 */NVL(TRE_.Is_Missed, 0) = 1\n").append("         AND rd.cn_plan_time                    <> 0\n").append("         AND (rd.cn_due_time / rd.cn_plan_time) <= 0.3\n").append("         THEN 1\n").append("         ELSE 0\n").append("       END AS com_executed_due_less,\n").append("       CASE\n").append("         WHEN rd.cd_confirmated                IS NOT NULL\n").append("         AND /*rd.cn_due_time > 0 */NVL(TRE_.Is_Missed, 0) = 1\n").append("         AND rd.cn_plan_time                   <> 0\n").append("         AND (rd.cn_due_time / rd.cn_plan_time) > 0.3\n").append("         THEN 1\n").append("         ELSE 0\n").append("       END AS com_executed_due_more,\n").append("       CASE\n").append("         WHEN rd.cd_confirmated IS NULL\n").append("         THEN 1\n").append("         ELSE 0\n").append("       END AS com_execute_count,\n").append("       CASE\n").append("         WHEN rd.cd_confirmated IS NULL\n").append("         AND rd.cs_extend        = '1'\n").append("         THEN 1\n").append("         ELSE 0\n").append("       END AS com_execute_extend,\n").append("       CASE\n").append("         WHEN rd.cd_confirmated                 IS NULL\n").append("         AND NVL(TRE_.Is_Missed, 0) = 1                \n").append("         AND rd.cn_plan_time                    <> 0\n").append("         AND /*rd.cn_due_time > 0 */NVL(TRE_.Is_Missed, 0) = 1\n").append("         AND (rd.cn_due_time / rd.cn_plan_time) <= 0.3\n").append("         THEN 1\n").append("         ELSE 0\n").append("       END AS com_due_less,\n").append("       CASE\n").append("         WHEN rd.cd_confirmated                IS NULL\n").append("         AND /*rd.cn_due_time > 0 */NVL(TRE_.Is_Missed, 0) = 1\n").append("         AND rd.cn_plan_time                   <> 0\n").append("         AND (rd.cn_due_time / rd.cn_plan_time) > 0.3\n").append("         THEN 1\n").append("         ELSE 0\n").append("       END                                         AS com_due_more,\n").append("       rd.cs_reject                                AS com_reject,\n").append("       rd.cn_accepted_time                         AS com_accept_time,\n").append("       rd.cn_executed_time - rd.cn_run_rework_time AS com_execute_time,\n").append("       rd.cn_finish_time                           AS com_finish_time,\n").append("       rd.cid_commission                           AS cid_commission\n").append("      ,tre_.operation_amount AS com_operations_count\n").append("       ,CASE WHEN rd.cd_confirmated IS NOT NULL\n").append("       THEN tre_.operation_amount\n").append("       END AS com_execute_operations_count\n").append("      ,CASE\n").append("       WHEN rd.cd_confirmated IS NOT NULL\n").append("       THEN To_Number(Trim(tre_.mark))\n").append("       END AS com_operations_mark\n").append("       ,(SELECT NVL(SUM(CASE WHEN tp.DESCRIPTION = 'Правка поручения' THEN 1 END), 0)\n").append("       || '|' || Count(*)\n").append("       FROM ecm.croc_group_oco_commission_sp grp\n").append("       ,ecm.crc_dict_topic_sp tp\n").append("       WHERE rd.cid_commission = grp.REGCARD_ID\n").append("       AND grp.TOPICS_ID = tp.R_OBJECT_ID\n").append("       ) cnt_corrections\n").append("       ,NVL(TRE_.is_missed_by_receiving, 0) cnt_missed_by_receiving\n").append("       ,CASE WHEN rd.cd_accepted IS NULL AND NVL(TRE_.Is_Missed, 0) = 1 THEN 1 ELSE 0 END as com_missed\n").append("       ,group_lvl.lvl AS lvl\n").append("     FROM crep_oco_comm_stat rd\n").append("     JOIN crep_departments org\n").append("     ON rd.cid_performer_top_dep = org.cid_department\n").append("     JOIN crep_departments dep\n").append("     ON rd.cid_performer_dep = dep.cid_department\n").append("     JOIN crep_positions pos\n").append("     ON rd.cid_performer = pos.cid_position\n").append("     JOIN crep_topics topic\n").append("     ON rd.cid_topic = topic.cid_topic\n").append("     CROSS JOIN\n").append("       (SELECT 0 AS lvl FROM dual\n").append("       UNION ALL\n").append("       SELECT 1 AS lvl FROM dual\n").append("       UNION ALL\n").append("       SELECT 2 AS lvl FROM dual\n").append("       UNION ALL\n").append("       SELECT 3 AS lvl FROM dual\n").append("       ) group_lvl\n").append("    JOIN ecm.CROC_GR_FREE_OCO_COMMISSION_S TRE_\n").append("     ON  rd.cid_commission = TRE_.r_object_id\n").append("      WHERE {0}\n").append("     ) report_info\n").append("   GROUP BY cid_performer_top_dep,\n").append("     cs_performer_top_dep,\n").append("     cid_performer_dep,\n").append("     cs_performer_dep,\n").append("     cid_performer,\n").append("     cs_performer,\n").append("     cid_topic,\n").append("     cs_topic,\n").append("     com_executed_not_due,\n").append("     com_executed_due_less,\n").append("     com_executed_due_more,\n").append("     com_execute_count,\n").append("     com_execute_extend,\n").append("     com_due_less,\n").append("     com_due_more,\n").append("     com_reject,\n").append("     com_accept_time,\n").append("     com_execute_time,\n").append("     com_finish_time,\n").append("     cid_commission,\n").append("     com_operations_count,\n").append("     com_operations_mark,\n").append("     lvl,\n").append("     cnt_corrections,\n").append("     cnt_missed_by_receiving,\n").append("     com_execute_operations_count,\n").append("     com_missed\n").append("   ) report_info2\n").append(" GROUP BY cid_performer_top_dep,\n").append("   cs_performer_top_dep,\n").append("   cid_performer_dep,\n").append("   cs_performer_dep,\n").append("   cid_performer,\n").append("   cs_performer,\n").append("   cid_topic,\n").append("   cs_topic,\n").append("   lvl\n").append(" ) report_data;").toString();
		while(true) {
			System.out.println(string.length());
			Thread.sleep(10000);
		}
	}

	private static void testStringConcatenationMemoryUse() throws InterruptedException {
		String string = "SELECT cid_performer_top_dep,\n" +
				" cs_performer_top_dep,\n" +
				" cid_performer_dep,\n" +
				" cs_performer_dep,\n" +
				" cid_performer,\n" +
				" cs_performer,\n" +
				" cid_topic,\n" +
				" cs_topic,\n" +
				" com_count,\n" +
				" TO_CHAR((com_executed_not_due  + com_executed_due_less + com_executed_due_more) / com_count * 100, '990.99')       AS percent_executed,\n" +
				" TO_CHAR(com_execute_count      / com_count * 100, '990.99')                                                        AS percent_execute,\n" +
				" TO_CHAR(CASE WHEN (com_executed_not_due  + com_executed_due_less + com_executed_due_more) > 0 THEN com_reject / (com_executed_not_due  + com_executed_due_less + com_executed_due_more) * 100 ELSE 0 END, '990.99') AS percent_reject,\n" +
				" TO_CHAR((com_executed_due_less + com_executed_due_more + com_due_less + com_due_more) / com_count * 100, '990.99') AS percent_due,\n" +
				" com_executed_not_due,\n" +
				" com_executed_due_less,\n" +
				" com_executed_due_more,\n" +
				" com_execute_count,\n" +
				" com_execute_extend,\n" +
				" com_due_less,\n" +
				" com_due_more,\n" +
				" TO_CHAR(com_accept_time, '99999999990')  AS com_accept_time,\n" +
				" TO_CHAR(com_execute_time, '99999999990') AS com_execute_time,\n" +
				" TO_CHAR(com_finish_time, '99999999990')  AS com_finish_time,\n" +
				" com_operations_count,\n" +
				" TO_CHAR(NVL(com_operations_mark, 0), '0.99')  AS com_operations_mark,\n" +
				" TO_CHAR(CASE WHEN (com_executed_not_due  + com_executed_due_less + com_executed_due_more) > 0 THEN cnt_corrections / (com_executed_not_due  + com_executed_due_less + com_executed_due_more) * 100 ELSE 0 END, '990.99') AS percent_corr,\n" +
				" TO_CHAR(com_reject / com_count * 100, '990.99') AS percent_missed_by_receiving,\n" +
				" com_execute_operations_count,\n" +
				" cnt_corrections as com_corr_count,\n" +
				" com_reject com_reject_count,\n" +
				" com_missed,\n" +
				" TO_CHAR(CASE WHEN /*(com_executed_not_due + com_executed_due_less + com_executed_due_more)*/com_count > 0 THEN\n" +
				" /*(com_executed_due_less + com_executed_due_more) / (com_executed_not_due + com_executed_due_less + com_executed_due_more)*/cnt_missed_by_receiving/com_count*100 ELSE 0 END, '990.99') prc_missed,\n" +
				"/*(                    + \"  (com_executed_not_due  + com_executed_due_less + com_executed_due_more) as com_executed, */\n" +
				" lvl\n" +
				" FROM\n" +
				" (SELECT cid_performer_top_dep,\n" +
				"   cs_performer_top_dep,\n" +
				"   cid_performer_dep,\n" +
				"   cs_performer_dep,\n" +
				"   cid_performer,\n" +
				"   cs_performer,\n" +
				"   cid_topic,\n" +
				"   cs_topic,\n" +
				"   SUM(com_executed_not_due)  AS com_executed_not_due,\n" +
				"   SUM(com_executed_due_less) AS com_executed_due_less,\n" +
				"   SUM(com_executed_due_more) AS com_executed_due_more,\n" +
				"   SUM(com_execute_count)     AS com_execute_count,\n" +
				"   SUM(com_execute_extend)    AS com_execute_extend,\n" +
				"   SUM(com_due_less)          AS com_due_less,\n" +
				"   SUM(com_due_more)          AS com_due_more,\n" +
				"   SUM(com_reject)            AS com_reject,\n" +
				"   AVG(com_accept_time)       AS com_accept_time,\n" +
				"   AVG(com_execute_time)      AS com_execute_time,\n" +
				"   AVG(com_finish_time)       AS com_finish_time,\n" +
				"   COUNT(cid_commission)      AS com_count,\n" +
				"   SUM(com_operations_count)  AS com_operations_count,\n" +
				"   AVG(com_operations_mark)   AS com_operations_mark,\n" +
				"   SUM(cnt_corrections)       AS cnt_corrections,\n" +
				"   SUM(cnt_all)               AS cnt_all,\n" +
				"   SUM(cnt_missed_by_receiving) AS cnt_missed_by_receiving,\n" +
				"   SUM(com_execute_operations_count) AS com_execute_operations_count,\n" +
				"   SUM(com_missed) as com_missed,\n" +
				"   lvl\n" +
				" FROM\n" +
				"   (SELECT cid_performer_top_dep ,\n" +
				"     cs_performer_top_dep ,\n" +
				"     cid_performer_dep ,\n" +
				"     cs_performer_dep ,\n" +
				"     cid_performer ,\n" +
				"     cs_performer ,\n" +
				"     cid_topic ,\n" +
				"     cs_topic ,\n" +
				"     com_executed_not_due ,\n" +
				"     com_executed_due_less ,\n" +
				"     com_executed_due_more ,\n" +
				"     com_execute_count ,\n" +
				"     com_execute_extend ,\n" +
				"     com_due_less ,\n" +
				"     com_due_more ,\n" +
				"     com_reject ,\n" +
				"     com_accept_time ,\n" +
				"     com_execute_time ,\n" +
				"     com_finish_time ,\n" +
				"     cid_commission ,\n" +
				"     com_operations_count ,\n" +
				"     CASE WHEN com_operations_mark = 0 THEN To_Number(NULL) ELSE com_operations_mark END com_operations_mark,\n" +
				"     lvl,\n" +
				"     To_Number(CASE WHEN cnt_corrections IS NOT NULL AND InStr(cnt_corrections, '|') > 0 THEN\n" +
				"                SubStr(cnt_corrections, 1, InStr(cnt_corrections, '|')-1)\n" +
				"     END) cnt_corrections,\n" +
				"     To_Number(CASE WHEN cnt_corrections IS NOT NULL AND InStr(cnt_corrections, '|') > 0 THEN\n" +
				"              SubStr(cnt_corrections, InStr(cnt_corrections, '|')+1)\n" +
				"     END) cnt_all,\n" +
				"     cnt_missed_by_receiving,\n" +
				"     com_execute_operations_count,\n" +
				"     com_missed\n" +
				"   FROM\n" +
				"     (SELECT\n" +
				"       CASE\n" +
				"         WHEN group_lvl.lvl = 0\n" +
				"         OR group_lvl.lvl   = 1\n" +
				"         OR group_lvl.lvl   = 2\n" +
				"         THEN rd.cid_performer_top_dep\n" +
				"         ELSE 'top_department'\n" +
				"       END AS cid_performer_top_dep,\n" +
				"       CASE\n" +
				"         WHEN group_lvl.lvl = 0\n" +
				"         OR group_lvl.lvl   = 1\n" +
				"         OR group_lvl.lvl   = 2\n" +
				"         THEN org.cs_department_description\n" +
				"         ELSE 'top_department'\n" +
				"       END AS cs_performer_top_dep,\n" +
				"       CASE\n" +
				"         WHEN group_lvl.lvl   = 1\n" +
				"         THEN rd.cid_performer_dep\n" +
				"         ELSE 'department'\n" +
				"       END AS cid_performer_dep,\n" +
				"       CASE\n" +
				"         WHEN group_lvl.lvl   = 1\n" +
				"         THEN dep.cs_department_description\n" +
				"         ELSE 'department'\n" +
				"       END AS cs_performer_dep,\n" +
				"       CASE\n" +
				"         WHEN group_lvl.lvl = 0\n" +
				"         THEN rd.cid_performer_emp\n" +
				"         ELSE 'performer'\n" +
				"       END AS cid_performer,\n" +
				"       CASE\n" +
				"         WHEN group_lvl.lvl = 0\n" +
				"         THEN pos.cs_user_description\n" +
				"         ELSE 'performer'\n" +
				"       END AS cs_performer,\n" +
				"       CASE\n" +
				"         WHEN group_lvl.lvl = 3\n" +
				"         THEN rd.cid_topic\n" +
				"         ELSE 'topic'\n" +
				"       END AS cid_topic,\n" +
				"       CASE\n" +
				"         WHEN group_lvl.lvl = 3\n" +
				"         THEN topic.cs_topic_description\n" +
				"         ELSE 'topic'\n" +
				"       END AS cs_topic,\n" +
				"       CASE\n" +
				"         WHEN rd.cd_confirmated IS NOT NULL\n" +
				"         /*AND rd.cn_due_time = 0*/\n" +
				"         AND NVL(TRE_.Is_Missed, 0) = 0\n" +
				"         THEN 1\n" +
				"         ELSE 0\n" +
				"       END AS com_executed_not_due,\n" +
				"       CASE\n" +
				"         WHEN rd.cd_confirmated                 IS NOT NULL\n" +
				"         AND /*rd.cn_due_time > 0 */NVL(TRE_.Is_Missed, 0) = 1\n" +
				"         AND rd.cn_plan_time                    <> 0\n" +
				"         AND (rd.cn_due_time / rd.cn_plan_time) <= 0.3\n" +
				"         THEN 1\n" +
				"         ELSE 0\n" +
				"       END AS com_executed_due_less,\n" +
				"       CASE\n" +
				"         WHEN rd.cd_confirmated                IS NOT NULL\n" +
				"         AND /*rd.cn_due_time > 0 */NVL(TRE_.Is_Missed, 0) = 1\n" +
				"         AND rd.cn_plan_time                   <> 0\n" +
				"         AND (rd.cn_due_time / rd.cn_plan_time) > 0.3\n" +
				"         THEN 1\n" +
				"         ELSE 0\n" +
				"       END AS com_executed_due_more,\n" +
				"       CASE\n" +
				"         WHEN rd.cd_confirmated IS NULL\n" +
				"         THEN 1\n" +
				"         ELSE 0\n" +
				"       END AS com_execute_count,\n" +
				"       CASE\n" +
				"         WHEN rd.cd_confirmated IS NULL\n" +
				"         AND rd.cs_extend        = '1'\n" +
				"         THEN 1\n" +
				"         ELSE 0\n" +
				"       END AS com_execute_extend,\n" +
				"       CASE\n" +
				"         WHEN rd.cd_confirmated                 IS NULL\n" +
				"         AND NVL(TRE_.Is_Missed, 0) = 1                \n" +
				"         AND rd.cn_plan_time                    <> 0\n" +
				"         AND /*rd.cn_due_time > 0 */NVL(TRE_.Is_Missed, 0) = 1\n" +
				"         AND (rd.cn_due_time / rd.cn_plan_time) <= 0.3\n" +
				"         THEN 1\n" +
				"         ELSE 0\n" +
				"       END AS com_due_less,\n" +
				"       CASE\n" +
				"         WHEN rd.cd_confirmated                IS NULL\n" +
				"         AND /*rd.cn_due_time > 0 */NVL(TRE_.Is_Missed, 0) = 1\n" +
				"         AND rd.cn_plan_time                   <> 0\n" +
				"         AND (rd.cn_due_time / rd.cn_plan_time) > 0.3\n" +
				"         THEN 1\n" +
				"         ELSE 0\n" +
				"       END                                         AS com_due_more,\n" +
				"       rd.cs_reject                                AS com_reject,\n" +
				"       rd.cn_accepted_time                         AS com_accept_time,\n" +
				"       rd.cn_executed_time - rd.cn_run_rework_time AS com_execute_time,\n" +
				"       rd.cn_finish_time                           AS com_finish_time,\n" +
				"       rd.cid_commission                           AS cid_commission\n" +
				"      ,tre_.operation_amount AS com_operations_count\n" +
				"       ,CASE WHEN rd.cd_confirmated IS NOT NULL\n" +
				"       THEN tre_.operation_amount\n" +
				"       END AS com_execute_operations_count\n" +
				"      ,CASE\n" +
				"       WHEN rd.cd_confirmated IS NOT NULL\n" +
				"       THEN To_Number(Trim(tre_.mark))\n" +
				"       END AS com_operations_mark\n" +
				"       ,(SELECT NVL(SUM(CASE WHEN tp.DESCRIPTION = 'Правка поручения' THEN 1 END), 0)\n" +
				"       || '|' || Count(*)\n" +
				"       FROM ecm.croc_group_oco_commission_sp grp\n" +
				"       ,ecm.crc_dict_topic_sp tp\n" +
				"       WHERE rd.cid_commission = grp.REGCARD_ID\n" +
				"       AND grp.TOPICS_ID = tp.R_OBJECT_ID\n" +
				"       ) cnt_corrections\n" +
				"       ,NVL(TRE_.is_missed_by_receiving, 0) cnt_missed_by_receiving\n" +
				"       ,CASE WHEN rd.cd_accepted IS NULL AND NVL(TRE_.Is_Missed, 0) = 1 THEN 1 ELSE 0 END as com_missed\n" +
				"       ,group_lvl.lvl AS lvl\n" +
				"     FROM crep_oco_comm_stat rd\n" +
				"     JOIN crep_departments org\n" +
				"     ON rd.cid_performer_top_dep = org.cid_department\n" +
				"     JOIN crep_departments dep\n" +
				"     ON rd.cid_performer_dep = dep.cid_department\n" +
				"     JOIN crep_positions pos\n" +
				"     ON rd.cid_performer = pos.cid_position\n" +
				"     JOIN crep_topics topic\n" +
				"     ON rd.cid_topic = topic.cid_topic\n" +
				"     CROSS JOIN\n" +
				"       (SELECT 0 AS lvl FROM dual\n" +
				"       UNION ALL\n" +
				"       SELECT 1 AS lvl FROM dual\n" +
				"       UNION ALL\n" +
				"       SELECT 2 AS lvl FROM dual\n" +
				"       UNION ALL\n" +
				"       SELECT 3 AS lvl FROM dual\n" +
				"       ) group_lvl\n" +
				"    JOIN ecm.CROC_GR_FREE_OCO_COMMISSION_S TRE_\n" +
				"     ON  rd.cid_commission = TRE_.r_object_id\n" +
				"      WHERE {0}\n" +
				"     ) report_info\n" +
				"   GROUP BY cid_performer_top_dep,\n" +
				"     cs_performer_top_dep,\n" +
				"     cid_performer_dep,\n" +
				"     cs_performer_dep,\n" +
				"     cid_performer,\n" +
				"     cs_performer,\n" +
				"     cid_topic,\n" +
				"     cs_topic,\n" +
				"     com_executed_not_due,\n" +
				"     com_executed_due_less,\n" +
				"     com_executed_due_more,\n" +
				"     com_execute_count,\n" +
				"     com_execute_extend,\n" +
				"     com_due_less,\n" +
				"     com_due_more,\n" +
				"     com_reject,\n" +
				"     com_accept_time,\n" +
				"     com_execute_time,\n" +
				"     com_finish_time,\n" +
				"     cid_commission,\n" +
				"     com_operations_count,\n" +
				"     com_operations_mark,\n" +
				"     lvl,\n" +
				"     cnt_corrections,\n" +
				"     cnt_missed_by_receiving,\n" +
				"     com_execute_operations_count,\n" +
				"     com_missed\n" +
				"   ) report_info2\n" +
				" GROUP BY cid_performer_top_dep,\n" +
				"   cs_performer_top_dep,\n" +
				"   cid_performer_dep,\n" +
				"   cs_performer_dep,\n" +
				"   cid_performer,\n" +
				"   cs_performer,\n" +
				"   cid_topic,\n" +
				"   cs_topic,\n" +
				"   lvl\n" +
				" ) report_data;";
		while(true) {
			System.out.println(string.length());
			Thread.sleep(10000);
		}
	}
}
