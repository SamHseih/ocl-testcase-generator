:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Matrix_Matrix_DC_Path_1_BDPath_1(Self,InputArray):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_datas,Self_dimensionSizes],Self_dimensionSizes = [2, 2],
InputArray_dimensionSizes = [2, 2],
decl_Array(Self_datas,Self_dimensionSizes),
decl_Array(InputArray,InputArray_dimensionSizes),


%CLG Path Constrints,
(Self_datas = InputArray),

%TypeVar Labeling Parts
labeling_Arrays([InputArray]).
