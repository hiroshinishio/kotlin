/*
 * Copyright 2010-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

#include "StableRef.hpp"

#include "MemoryPrivate.hpp"
#include "ThreadData.hpp"
#include "ThreadRegistry.hpp"
#include "ThreadState.hpp"

using namespace kotlin;

// static
ALWAYS_INLINE mm::StableRef mm::StableRef::create(ObjHeader* obj) noexcept {
    RuntimeAssert(obj != nullptr, "Creating StableRef for null object");
    return mm::ThreadRegistry::Instance().CurrentThreadData()->specialRefRegistry().createStableRef(obj);
}

void mm::StableRef::logDispose() noexcept {
    ProfilerHit(mm::ThreadRegistry::Instance().CurrentThreadData()->profilers().specialRef(),
                {profiler::SpecialRefEventTraits::SpecialRefKind::kBackRef, profiler::SpecialRefEventTraits::OpKind::kDisposed});
}
