/*
 * Copyright 2017-2018 Micro Focus or one of its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hpe.caf.worker.binaryhash;

import com.hpe.caf.api.worker.TaskMessage;
import com.hpe.caf.worker.testing.TestConfiguration;
import com.hpe.caf.worker.testing.TestItem;
import com.hpe.caf.worker.testing.WorkerServices;
import com.hpe.caf.worker.testing.preparation.PreparationResultProcessor;

public class BinaryHashSaveResultProcessor extends
    PreparationResultProcessor<BinaryHashWorkerTask, BinaryHashWorkerResult, BinaryHashTestInput, BinaryHashTestExpectation>
{
    public BinaryHashSaveResultProcessor(TestConfiguration<BinaryHashWorkerTask, BinaryHashWorkerResult, BinaryHashTestInput, BinaryHashTestExpectation> configuration,
                                         WorkerServices workerServices)
    {

        super(configuration, workerServices.getCodec());
    }

    @Override
    protected byte[] getOutputContent(BinaryHashWorkerResult workerResult,
                                      TaskMessage message, TestItem<BinaryHashTestInput, BinaryHashTestExpectation> testItem)
        throws Exception
    {

        testItem.getExpectedOutputData().status = workerResult.workerStatus;
        testItem.getExpectedOutputData().hashResult = workerResult.hashResult;
        return super.getOutputContent(workerResult, message, testItem);
    }
}
