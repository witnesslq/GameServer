/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package experiment.hashwheel;

/**
 * A handle associated with a {@link ITimerTask} that is returned by a
 * {@link ITimer}.
 */
public interface ITimeout{

    /**
     * Returns the {@link ITimer} that created this handle.
     */
    ITimer timer();

    /**
     * Returns the {@link ITimerTask} which is associated with this handle.
     */
    ITimerTask task();

    /**
     * Returns {@code true} if and only if the {@link ITimerTask} associated
     * with this handle has been expired.
     */
    boolean isExpired();

    /**
     * Returns {@code true} if and only if the {@link ITimerTask} associated
     * with this handle has been cancelled.
     */
    boolean isCancelled();

    /**
     * Attempts to cancel the {@link ITimerTask} associated with this handle.
     * If the task has been executed or cancelled already, it will return with
     * no side effect.
     *
     * @return True if the cancellation completed successfully, otherwise false
     */
    boolean cancel();
}
